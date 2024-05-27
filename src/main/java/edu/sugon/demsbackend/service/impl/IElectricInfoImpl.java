package edu.sugon.demsbackend.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import edu.sugon.demsbackend.common.BaseUtil;
import edu.sugon.demsbackend.common.PageResult;
import edu.sugon.demsbackend.dao.ElectricInfoDao;
import edu.sugon.demsbackend.entity.ElectricInfo;
import edu.sugon.demsbackend.enums.YesNoEnum;
import edu.sugon.demsbackend.service.IElectricInfo;
import edu.sugon.demsbackend.vo.ElectricInfoPageVo;
import edu.sugon.demsbackend.vo.ElectricInfoVo;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Service
public class IElectricInfoImpl extends ServiceImpl<ElectricInfoDao, ElectricInfo> implements IElectricInfo {

    @Override
    public boolean save(ElectricInfoVo vo) throws Exception {
        QueryWrapper<ElectricInfo> wrapper = new QueryWrapper<>();
        wrapper.lambda()
                .eq(ElectricInfo::getMeterNo, vo.getMeterNo())
                .eq(ElectricInfo::getDeleteFlag, YesNoEnum.NO.getValue());
        ElectricInfo entity = this.getOne(wrapper);
        if (Objects.nonNull(entity)){
            throw new Exception("电表编号已存在!");
        }
        if (BaseUtil.hasSpaceChar(vo.getMeterNo())){
            throw new Exception("电表编号不可包含空格!");
        }
        if (BaseUtil.strIsEmpty(vo.getMeterNo())){
            throw new Exception("电表编号不能为空");
        }
        entity = new ElectricInfo();
        BeanUtils.copyProperties(vo, entity);
        entity.preSave(StpUtil.getLoginIdAsString());
        return super.save(entity);
    }

    @Override
    public boolean update(ElectricInfoVo vo) throws Exception {
        QueryWrapper<ElectricInfo> wrapper = new QueryWrapper<>();
        QueryWrapper<ElectricInfo> wrapper1 = new QueryWrapper<>();
        wrapper.lambda()
                .eq(ElectricInfo::getId, vo.getId())
                .eq(ElectricInfo::getDeleteFlag, YesNoEnum.NO.getValue());
        ElectricInfo entity = this.getOne(wrapper);
        if (Objects.isNull(entity)){
            throw new Exception("电表信息不存在!");
        }
        wrapper1.lambda()
                .eq(ElectricInfo::getMeterNo, vo.getMeterNo())
                .eq(ElectricInfo::getDeleteFlag, YesNoEnum.NO.getValue());
        ElectricInfo entity1 = this.getOne(wrapper1);
        if (Objects.nonNull(entity1) && (!vo.getId().equals(entity1.getId()))){
            throw new Exception("电表编号已存在!");
        }
        if (BaseUtil.hasSpaceChar(vo.getMeterNo())){
            throw new Exception("电表编号不可包含空格!");
        }
        if (BaseUtil.strIsEmpty(vo.getMeterNo())){
            throw new Exception("电表编号不能为空");
        }
        BeanUtils.copyProperties(vo, entity);
        entity.preUpdate(StpUtil.getLoginIdAsString());
        return super.updateById(entity);
    }

    @Override
    public PageResult<ElectricInfo> page(ElectricInfoPageVo vo) {
        IPage<ElectricInfo> page = new Page<>(vo.getCurrent(), vo.getPageSize());
        QueryWrapper<ElectricInfo> wrapper = new QueryWrapper<>();
        wrapper.lambda()
                .like(Strings.isNotEmpty(vo.getMeterNo()), ElectricInfo::getMeterNo, vo.getMeterNo())
                .eq(ElectricInfo::getDeleteFlag, YesNoEnum.NO.getValue());
        page = this.page(page, wrapper);
        PageResult<ElectricInfo> result = new PageResult<>();
        result.setItems(page.getRecords());
        result.setTotal(page.getTotal());
        return result;
    }

    @Override
    public ElectricInfo getById(Serializable id) {
        QueryWrapper<ElectricInfo> wrapper = new QueryWrapper<>();
        wrapper.lambda()
                .eq(ElectricInfo::getId, id)
                .eq(ElectricInfo::getDeleteFlag, YesNoEnum.NO.getValue());
        return this.getOne(wrapper);
    }

    @Override
    public void delete(List<String> ids) {
        String userId = StpUtil.getLoginIdAsString();
        if (Objects.nonNull(ids)){
            for (String id : ids){
                ElectricInfo info = getById(id);
                if (Objects.nonNull(info)){
                    info.preDelete(userId);
                    this.updateById(info);
                }
            }
        }
    }
}
