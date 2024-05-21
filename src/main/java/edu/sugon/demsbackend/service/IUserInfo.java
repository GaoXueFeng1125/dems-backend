package edu.sugon.demsbackend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import edu.sugon.demsbackend.common.PageResult;
import edu.sugon.demsbackend.entity.UserInfo;
import edu.sugon.demsbackend.vo.UserInfoPageVo;
import edu.sugon.demsbackend.vo.UserInfoVo;

import java.util.List;

public interface IUserInfo extends IService<UserInfo> {
    //新增用户
    boolean save(UserInfoVo vo) throws Exception;
    //修改用户
    boolean update(UserInfoVo vo) throws Exception;
    //分页查询
    PageResult<UserInfo> page(UserInfoPageVo vo);
    //批量删除
    void delete(List<String> ids);

}
