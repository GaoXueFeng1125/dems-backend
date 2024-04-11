package edu.sugon.demsbackend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import edu.sugon.demsbackend.common.PageResult;
import edu.sugon.demsbackend.entity.RoleInfo;
import edu.sugon.demsbackend.vo.RoleInfoPageVo;
import edu.sugon.demsbackend.vo.RoleInfoVo;

import java.util.List;

public interface IRoleInfo extends IService<RoleInfo> {

    //新增角色
    boolean save(RoleInfoVo vo) throws Exception;
    //修改角色
    boolean update(RoleInfoVo vo) throws Exception;
    //分页查询
    PageResult<RoleInfo> page(RoleInfoPageVo vo);
    //批量删除
    void delete(List<String> ids);
}
