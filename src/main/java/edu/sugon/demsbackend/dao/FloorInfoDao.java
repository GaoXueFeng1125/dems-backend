package edu.sugon.demsbackend.dao;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import edu.sugon.demsbackend.entity.FloorInfo;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface FloorInfoDao extends BaseMapper<FloorInfo> {
}
