package edu.sugon.demsbackend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import edu.sugon.demsbackend.common.PageResult;
import edu.sugon.demsbackend.entity.PermissionsInfo;
import edu.sugon.demsbackend.vo.PermissionsInfoPageVo;
import edu.sugon.demsbackend.vo.PermissionsInfoVo;

import java.util.List;

public interface IPermissionsInfo extends IService<PermissionsInfo> {
    //新增权限
    boolean save(PermissionsInfoVo vo) throws Exception;
    //修改权限
    boolean update(PermissionsInfoVo vo) throws Exception;
    //分页查询
    PageResult<PermissionsInfo> page(PermissionsInfoPageVo vo);
    //批量删除
    void delete(List<String> ids);
}
