package edu.sugon.demsbackend.dao;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import edu.sugon.demsbackend.entity.FloorInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;


@Mapper
public interface FloorInfoDao extends BaseMapper<FloorInfo> {
    @Select(
            "select floor_info.*,build_info.BUILDINGS_NO " +
                    "from floor_info " +
                    "inner join  build_info " +
                    "on floor_info.BUILDINGS_ID = build_info.ID ${ew.customSqlSegment}"
    )
    IPage<FloorInfo> selectPage(IPage<FloorInfo> page, @Param("ew") QueryWrapper<FloorInfo> queryWrapper);
}
