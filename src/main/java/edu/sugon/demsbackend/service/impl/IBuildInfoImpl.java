package edu.sugon.demsbackend.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import edu.sugon.demsbackend.common.BaseUtil;
import edu.sugon.demsbackend.common.PageResult;
import edu.sugon.demsbackend.dao.BuildInfoDao;
import edu.sugon.demsbackend.entity.BuildInfo;
import edu.sugon.demsbackend.enums.YesNoEnum;
import edu.sugon.demsbackend.service.IBuildInfo;
import edu.sugon.demsbackend.vo.BuildInfoPageVo;
import edu.sugon.demsbackend.vo.BuildInfoVo;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Service
public class IBuildInfoImpl extends ServiceImpl<BuildInfoDao, BuildInfo>
implements IBuildInfo {
    @Override
    public boolean save(BuildInfoVo vo) throws Exception {
        QueryWrapper<BuildInfo> wrapper = new QueryWrapper<>();
        wrapper.lambda()
                .eq(BuildInfo::getBuildingsNo,vo.getBuildingsName())
                .eq(BuildInfo::getDeleteFlag, YesNoEnum.NO.getValue());
        BuildInfo entity = this.getOne(wrapper);
        if(Objects.nonNull(entity)){
            throw new Exception("楼栋号已存在");
        }
        if (BaseUtil.strIsEmpty(vo.getBuildingsNo())){
            throw new Exception("楼栋号不能为空");
        }
        entity = new BuildInfo();
        BeanUtils.copyProperties(vo,entity);
        entity.preSave(StpUtil.getLoginIdAsString());
        return super.save(entity);
    }

    @Override
    public boolean update(BuildInfoVo vo) throws Exception {
        QueryWrapper<BuildInfo> wrapper = new QueryWrapper<>();
        wrapper.lambda()
                .eq(BuildInfo::getId,vo.getId())
                .eq(BuildInfo::getDeleteFlag,YesNoEnum.NO.getValue());
        BuildInfo entity = this.getOne(wrapper);
        if (Objects.isNull(entity)){
            throw new Exception("楼栋不存在");
        }
        if (BaseUtil.strIsEmpty(vo.getBuildingsNo())){
            throw new Exception("楼栋号不能为空");
        }
        BeanUtils.copyProperties(vo,entity);
        entity.preUpdate(StpUtil.getLoginIdAsString());
        return super.updateById(entity);
    }

    @Override
    public BuildInfo getById(Serializable id){
        QueryWrapper<BuildInfo> wrapper = new QueryWrapper<>();
        wrapper.lambda()
                .eq(BuildInfo::getId,id)
                .eq(BuildInfo::getDeleteFlag,YesNoEnum.NO.getValue());
        return this.getOne(wrapper);
    }

    @Override
    public PageResult<BuildInfo> page(BuildInfoPageVo vo) {
        IPage<BuildInfo> page = new Page<>(vo.getCurrent(),vo.getPageSize());
        QueryWrapper<BuildInfo> wrapper = new QueryWrapper<>();
        wrapper.lambda()
                .like(Strings.isNotEmpty(vo.getBuildingsNo()),
                        BuildInfo::getBuildingsNo,vo.getBuildingsNo())
                .like(Strings.isNotEmpty(vo.getBuildingsName()),
                        BuildInfo::getBuildingsName,vo.getBuildingsName())
                .eq(BuildInfo::getDeleteFlag,YesNoEnum.NO.getValue());

        page = this.page(page,wrapper);
        PageResult<BuildInfo> result = new PageResult<>();
        result.setItems(page.getRecords());
        result.setTotal(page.getTotal());
        return result;
    }

    @Override
    public void delete(List<String> ids) {
        String userId = StpUtil.getLoginIdAsString();
        if (Objects.nonNull(ids)){
            for (String id : ids){
                BuildInfo info = this.getById(id);
                if(Objects.nonNull(info)){
                    info.preDelete(userId);
                    this.updateById(info);
                }
            }
        }
    }
}
