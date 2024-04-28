package edu.sugon.demsbackend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import edu.sugon.demsbackend.common.PageResult;
import edu.sugon.demsbackend.entity.FloorInfo;
import edu.sugon.demsbackend.vo.FloorInfoPageVo;
import edu.sugon.demsbackend.vo.FloorInfoVo;

import java.util.List;

public interface IFloorInfo extends IService<FloorInfo> {
    //新增楼栋
    boolean save(FloorInfoVo vo) throws Exception;
    //修改楼栋
    boolean update(FloorInfoVo vo) throws Exception;
    //分页查询
    PageResult<FloorInfo> page(FloorInfoPageVo vo);
    //批量删除
    void delete(List<String> ids);
}
