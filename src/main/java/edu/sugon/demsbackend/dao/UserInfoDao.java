package edu.sugon.demsbackend.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import edu.sugon.demsbackend.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserInfoDao extends BaseMapper<UserInfo> {
}
