package edu.sugon.demsbackend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import edu.sugon.demsbackend.common.PageResult;
import edu.sugon.demsbackend.entity.ElectricInfo;
import edu.sugon.demsbackend.vo.ElectricInfoPageVo;
import edu.sugon.demsbackend.vo.ElectricInfoVo;


import java.util.List;

public interface IElectricInfo extends IService<ElectricInfo> {

    //新增电表信息
    boolean save(ElectricInfoVo vo) throws Exception;

    //修改电表信息
    boolean update(ElectricInfoVo vo) throws Exception;

    //分页查询电表信息
    PageResult<ElectricInfo> page(ElectricInfoPageVo vo);

    //批量删除电表信息
    void delete(List<String> ids);
}
