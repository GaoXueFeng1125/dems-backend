package edu.sugon.demsbackend.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import edu.sugon.demsbackend.common.BaseUtil;
import edu.sugon.demsbackend.common.PageResult;
import edu.sugon.demsbackend.dao.FloorInfoDao;
import edu.sugon.demsbackend.entity.BuildInfo;
import edu.sugon.demsbackend.entity.FloorInfo;
import edu.sugon.demsbackend.enums.YesNoEnum;
import edu.sugon.demsbackend.service.IBuildInfo;
import edu.sugon.demsbackend.service.IFloorInfo;
import edu.sugon.demsbackend.vo.FloorInfoPageVo;
import edu.sugon.demsbackend.vo.FloorInfoVo;
import jakarta.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Service
public class IFloorInfoImpl extends ServiceImpl<FloorInfoDao, FloorInfo>
implements IFloorInfo {
    @Resource
    private IBuildInfo iBuildInfo;
    @Override
    public boolean save(FloorInfoVo vo) throws Exception {
        QueryWrapper<FloorInfo> wrapper = new QueryWrapper<>();
        QueryWrapper<BuildInfo> wrapper2 = new QueryWrapper<>();
        wrapper.lambda()
                .eq(FloorInfo::getFloorNo,vo.getFloorNo())
                .eq(FloorInfo::getBuildingsId,vo.getBuildingsId())
                .eq(FloorInfo::getDeleteFlag, YesNoEnum.NO.getValue());
        wrapper2.lambda()
                .eq(BuildInfo::getId,vo.getBuildingsId())
                .eq(BuildInfo::getDeleteFlag,YesNoEnum.NO.getValue());
        FloorInfo entity = this.getOne(wrapper);
        BuildInfo entity2 = iBuildInfo.getOne(wrapper2);
        if (Objects.isNull(entity2)){
            throw new Exception("楼栋不存在");
        }
        if (Objects.nonNull(entity)){
            throw new Exception("楼层已存在");
        }
        if (BaseUtil.strIsEmpty(vo.getFloorNo())){
            throw new Exception("楼层号不可为空");
        }
        if (BaseUtil.strIsEmpty(vo.getBuildingsId())){
            throw new Exception("楼栋ID不可为空");
        }
        entity = new FloorInfo();
        BeanUtils.copyProperties(vo,entity);
        entity.preSave(StpUtil.getLoginIdAsString());
        return super.save(entity);
    }

    @Override
    public boolean update(FloorInfoVo vo) throws Exception {
        QueryWrapper<FloorInfo> wrapper = new QueryWrapper<>();
//        wrapper1用于查询楼层是否存在
        QueryWrapper<FloorInfo> wrapper1 = new QueryWrapper<>();
//        wrapper2用于查询楼栋是否存在
        QueryWrapper<BuildInfo> wrapper2 = new QueryWrapper<>();
        wrapper.lambda()
                .eq(FloorInfo::getId,vo.getId())
                .eq(FloorInfo::getDeleteFlag,YesNoEnum.NO.getValue());
        wrapper1.lambda()
                .eq(FloorInfo::getFloorNo,vo.getFloorNo())
                .eq(FloorInfo::getBuildingsId,vo.getBuildingsId())
                .eq(FloorInfo::getDeleteFlag, YesNoEnum.NO.getValue());
        wrapper2.lambda()
                .eq(BuildInfo::getId,vo.getBuildingsId())
                .eq(BuildInfo::getDeleteFlag,YesNoEnum.NO.getValue());
        FloorInfo entity = this.getOne(wrapper);
        FloorInfo entity1 = this.getOne(wrapper1);
        BuildInfo entity2 = iBuildInfo.getOne(wrapper2);

        if (Objects.isNull(entity2)){
            throw new Exception("楼栋不存在");
        }
        if (Objects.isNull(entity)){
            throw new Exception("楼层不存在");
        }
        if (Objects.nonNull(entity1) && (!vo.getId().equals(entity1.getId()))){
            throw new Exception("楼层已存在");
        }
        if (BaseUtil.strIsEmpty(vo.getFloorNo())){
            throw new Exception("楼层号不可为空");
        }
        if (BaseUtil.strIsEmpty(vo.getBuildingsId())){
            throw new Exception("楼栋ID不可为空");
        }
        BeanUtils.copyProperties(vo,entity);
        entity.preUpdate(StpUtil.getLoginIdAsString());
        return super.updateById(entity);
    }

    @Override
    public PageResult<FloorInfo> page(FloorInfoPageVo vo) {
        IPage<FloorInfo> page = new Page<>(vo.getCurrent(),vo.getPageSize());
        QueryWrapper<FloorInfo> wrapper = new QueryWrapper<>();
        wrapper.eq("floor_info.DELETE_FLAG",YesNoEnum.NO.getValue())
                .lambda()
                .like(FloorInfo::getFloorNo,vo.getFloorNo())
                .eq(FloorInfo::getBuildingsId,vo.getBuildingsId());
//        page = this.page(page,wrapper);
        page = this.baseMapper.selectPage(page,wrapper);
        PageResult<FloorInfo> result = new PageResult<>();
        result.setItems(page.getRecords());
        result.setTotal(page.getTotal());
        return result;
    }

    @Override
    public FloorInfo getById(Serializable id) {
        QueryWrapper<FloorInfo> wrapper = new QueryWrapper<>();
        wrapper.lambda()
                .eq(FloorInfo::getId,id)
                .eq(FloorInfo::getDeleteFlag,YesNoEnum.NO.getValue());
        return this.getOne(wrapper);
    }
    @Override
    public void delete(List<String> ids) {
        String userId = StpUtil.getLoginIdAsString();
        if (Objects.nonNull(ids)){
            for (String id : ids){
                FloorInfo info = getById(id);
                if (Objects.nonNull(info)){
                    info.preDelete(userId);
                    this.updateById(info);
                }
            }
        }
    }
}
