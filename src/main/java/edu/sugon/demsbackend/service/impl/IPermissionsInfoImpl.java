package edu.sugon.demsbackend.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import edu.sugon.demsbackend.common.PageResult;
import edu.sugon.demsbackend.dao.PermissionsInfoDao;
import edu.sugon.demsbackend.entity.PermissionsInfo;
import edu.sugon.demsbackend.enums.YesNoEnum;
import edu.sugon.demsbackend.service.IPermissionsInfo;
import edu.sugon.demsbackend.vo.PermissionsInfoPageVo;
import edu.sugon.demsbackend.vo.PermissionsInfoVo;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Service
public class IPermissionsInfoImpl extends ServiceImpl<PermissionsInfoDao, PermissionsInfo>
implements IPermissionsInfo {
    @Override
    public boolean save(PermissionsInfoVo vo) throws Exception {
        QueryWrapper<PermissionsInfo> wrapper = new QueryWrapper<>();
        QueryWrapper<PermissionsInfo> wrapperRoute = new QueryWrapper<>();
        wrapper.lambda()
                .eq(PermissionsInfo::getPermissionName,vo.getPermissionName())
                .eq(PermissionsInfo::getDeleteFlag, YesNoEnum.NO.getValue());

        wrapperRoute.lambda()
                .eq(PermissionsInfo::getRoute,vo.getRoute())
                .eq(PermissionsInfo::getDeleteFlag,YesNoEnum.NO.getValue());

        PermissionsInfo entity = this.getOne(wrapper);
        PermissionsInfo entityRoute = this.getOne(wrapperRoute);
        if (Objects.nonNull(entity)){
            throw new Exception("权限名称已存在");
        }
        if (Objects.nonNull(entityRoute)){
            throw new Exception("路由已存在");
        }
        entity = new PermissionsInfo();
        BeanUtils.copyProperties(vo,entity);
        entity.preSave(StpUtil.getLoginIdAsString());
        return super.save(entity);

    }

    @Override
    public boolean update(PermissionsInfoVo vo) throws Exception {
        QueryWrapper<PermissionsInfo> wrapperName = new QueryWrapper<>();
        QueryWrapper<PermissionsInfo> wrapperRoute = new QueryWrapper<>();
        QueryWrapper<PermissionsInfo> wrapperId = new QueryWrapper<>();
        wrapperName.lambda()
                .eq(PermissionsInfo::getPermissionName,vo.getPermissionName())
                .eq(PermissionsInfo::getDeleteFlag, YesNoEnum.NO.getValue());

        wrapperRoute.lambda()
                .eq(PermissionsInfo::getRoute,vo.getRoute())
                .eq(PermissionsInfo::getDeleteFlag,YesNoEnum.NO.getValue());

        wrapperId.lambda()
                .eq(PermissionsInfo::getId,vo.getId())
                .eq(PermissionsInfo::getDeleteFlag,YesNoEnum.NO.getValue());
        PermissionsInfo entityName = this.getOne(wrapperName);
        PermissionsInfo entityRoute = this.getOne(wrapperRoute);
        PermissionsInfo entityId = this.getOne(wrapperId);
        if (Objects.nonNull(entityName)){
            throw new Exception("权限名称已存在");
        }
        if (Objects.nonNull(entityRoute)){
            throw new Exception("路由已存在");
        }
        if (Objects.isNull(entityId)){
            throw new Exception("权限不存在");
        }
        BeanUtils.copyProperties(vo,entityId);
        entityId.preUpdate(StpUtil.getLoginIdAsString());
        return super.updateById(entityId);
    }


    @Override
    public PageResult<PermissionsInfo> page(PermissionsInfoPageVo vo) {
        IPage<PermissionsInfo> page = new Page<>(vo.getCur(),vo.getPageSize());
        QueryWrapper<PermissionsInfo> wrapper = new QueryWrapper<>();
        wrapper.lambda()
                .like(Strings.isNotEmpty(vo.getPermissionName()),PermissionsInfo::getPermissionName,vo.getPermissionName())
                .eq(PermissionsInfo::getDeleteFlag,YesNoEnum.NO.getValue());
        page = this.page(page,wrapper);
        PageResult<PermissionsInfo> result = new PageResult<>();
        result.setItems(page.getRecords());
        result.setTotal(page.getTotal());
        return result;
    }

    @Override
    public PermissionsInfo getById(Serializable id){
        QueryWrapper<PermissionsInfo> wrapper = new QueryWrapper<>();
        wrapper.lambda()
                .eq(PermissionsInfo::getId,id)
                .eq(PermissionsInfo::getDeleteFlag,YesNoEnum.NO.getValue());
        return this.getOne(wrapper);
    }

    @Override
    public void delete(List<String> ids) {
        String userId = StpUtil.getLoginIdAsString();
        if(Objects.nonNull(ids)){
            for (String id : ids){
                PermissionsInfo info = this.getById(id);
                if (Objects.nonNull(info)){
                    info.preDelete(userId);
                    this.updateById(info);
                }
            }
        }
    }
}
