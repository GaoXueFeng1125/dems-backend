package edu.sugon.demsbackend.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import edu.sugon.demsbackend.common.PageResult;
import edu.sugon.demsbackend.dao.RoleInfoDao;
import edu.sugon.demsbackend.entity.RoleInfo;
import edu.sugon.demsbackend.enums.YesNoEnum;
import edu.sugon.demsbackend.service.IRoleInfo;
import edu.sugon.demsbackend.vo.RoleInfoPageVo;
import edu.sugon.demsbackend.vo.RoleInfoVo;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Service
public class IRoleInfoImpl extends ServiceImpl<RoleInfoDao, RoleInfo>
implements IRoleInfo {

    @Override
    public boolean save(RoleInfoVo vo) throws Exception {
        QueryWrapper<RoleInfo> wrapper = new QueryWrapper<>();
        wrapper.lambda()
                .eq(RoleInfo::getRoleName,vo.getRoleName())
                .eq(RoleInfo::getDeleteFlag, YesNoEnum.NO.getValue());
        RoleInfo entity = this.getOne(wrapper);
        if (Objects.nonNull(entity)){
            throw new Exception("角色名称已存在!");
        }
        entity = new RoleInfo();
        BeanUtils.copyProperties(vo,entity);
        entity.preSave(StpUtil.getLoginIdAsString());
        return super.save(entity);
    }

    @Override
    public boolean update(RoleInfoVo vo) throws Exception {
        QueryWrapper<RoleInfo> wrapper = new QueryWrapper<>();
        //wrapper1用作角色名称查询器
        QueryWrapper<RoleInfo> wrapper1 = new QueryWrapper<>();
        wrapper.lambda()
                .eq(RoleInfo::getId,vo.getId())
                .eq(RoleInfo::getDeleteFlag,YesNoEnum.NO.getValue());
        RoleInfo entity = this.getOne(wrapper);
        if (Objects.isNull(entity)){
            throw new Exception("角色不存在!");
        }
        //wrapper1用作角色名称查询器，这里进行角色名称查询
        wrapper1.lambda()
                .eq(RoleInfo::getRoleName,vo.getRoleName())
                .eq(RoleInfo::getDeleteFlag,YesNoEnum.NO.getValue());
        //entity1用作接受wrapper1结果 如果可以查到说明角色名称已存在 则执行下面的if
        RoleInfo entity1 = this.getOne(wrapper1);
        if (Objects.nonNull(entity1)){
            throw new Exception("角色已存在!");
        }

        BeanUtils.copyProperties(vo,entity);
        entity.preUpdate(StpUtil.getLoginIdAsString());
        return super.updateById(entity);
    }

    @Override
    public PageResult<RoleInfo> page(RoleInfoPageVo vo) {
        IPage<RoleInfo> page = new Page<>(vo.getCur(),vo.getPageSize());
        QueryWrapper<RoleInfo> wrapper = new QueryWrapper<>();
        wrapper.lambda()
                .like(Strings.isNotEmpty(vo.getRoleName()),
                        RoleInfo::getRoleName,vo.getRoleName())
                .eq(RoleInfo::getDeleteFlag,YesNoEnum.NO.getValue());
        page = this.page(page,wrapper);
        PageResult<RoleInfo> result = new PageResult<>();
        result.setItems(page.getRecords());
        result.setTotal(page.getTotal());
        return result;
    }

    @Override
    public RoleInfo getById(Serializable id){
        QueryWrapper<RoleInfo> wrapper = new QueryWrapper<>();
        wrapper.lambda()
                .eq(RoleInfo::getId,id)
                .eq(RoleInfo::getDeleteFlag,YesNoEnum.NO.getValue());
        return this.getOne(wrapper);
    }
    @Override
    public void delete(List<String> ids) {
        String userId = StpUtil.getLoginIdAsString();
        if (Objects.nonNull(ids)){
            for (String id : ids){
                RoleInfo info = this.getById(id);
                if(Objects.nonNull(info)){
                    info.preDelete(userId);
                    this.updateById(info);
                }
            }
        }
    }
}
