package edu.sugon.demsbackend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import edu.sugon.demsbackend.common.PageResult;
import edu.sugon.demsbackend.dao.UserInfoDao;
import edu.sugon.demsbackend.entity.UserInfo;
import edu.sugon.demsbackend.service.IUserInfo;
import edu.sugon.demsbackend.vo.UserInfoPageVo;
import edu.sugon.demsbackend.vo.UserInfoVo;

import java.io.Serializable;
import java.util.List;

public class IUserInfoImpl extends ServiceImpl<UserInfoDao, UserInfo>
implements IUserInfo {
    @Override
    public boolean save(UserInfoVo vo) throws Exception {
        QueryWrapper<UserInfo> wrapper = new QueryWrapper<>();
        return false;
    }

    @Override
    public boolean update(UserInfoVo vo) throws Exception {
        return false;
    }

    @Override
    public PageResult<UserInfo> page(UserInfoPageVo vo) {
        return null;
    }

    @Override
    public void delete(List<String> ids) {

    }

    @Override
    public UserInfo getById(Serializable id) {
        return super.getById(id);
    }
}
