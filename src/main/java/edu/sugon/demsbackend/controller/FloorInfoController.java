package edu.sugon.demsbackend.controller;

import edu.sugon.demsbackend.common.BaseUtil;
import edu.sugon.demsbackend.common.PageResult;
import edu.sugon.demsbackend.common.Result;

import edu.sugon.demsbackend.entity.FloorInfo;
import edu.sugon.demsbackend.service.IFloorInfo;

import edu.sugon.demsbackend.vo.FloorInfoPageVo;
import edu.sugon.demsbackend.vo.FloorInfoVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "楼层信息")
@RequestMapping("/floor")
public class FloorInfoController {
    @Resource
    private IFloorInfo iFloorInfo;
    @Operation(summary = "根据楼层号与所属楼栋查询分页")
    @Parameters({
            @Parameter(name = "current",description = "当前页",in = ParameterIn.QUERY),
            @Parameter(name = "pageSize",description = "每页条数",in = ParameterIn.QUERY),
            @Parameter(name = "floorNo",description = "楼层号",in = ParameterIn.QUERY),
            @Parameter(name = "buildingsId",description = "楼栋ID",in = ParameterIn.QUERY)
    })
    @GetMapping("/page")
    public Result<PageResult<FloorInfo>> page(@Parameter(hidden = true) FloorInfoPageVo vo){
        return Result.success(iFloorInfo.page(vo));
    }

    @Operation(summary = "根据ID获取楼层信息")
    @GetMapping("/{id}")
    public Result<FloorInfo> getById(@PathVariable("id") String id){
        FloorInfo info = iFloorInfo.getById(id);
        return Result.success(info);
    }

    @Operation(summary = "添加楼层")
    @PostMapping()
    public Result<FloorInfo> save(@RequestBody FloorInfoVo vo) throws Exception {
        if (!BaseUtil.isPositiveInt(vo.getFloorNo())){
            throw new Exception("楼栋层不能为空且只能为正整数!");
        }
        iFloorInfo.save(vo);
        return Result.success();
    }

    @Operation(summary = "修改楼层")
    @PutMapping()
    public Result<FloorInfo> update(@RequestBody FloorInfoVo vo) throws Exception {
        if (!BaseUtil.isPositiveInt(vo.getFloorNo())){
            throw new Exception("楼栋层不能为空且只能为正整数!");
        }
        iFloorInfo.update(vo);
        return Result.success();
    }

    @Operation(summary = "根据ID批量删除楼层信息")
    @DeleteMapping("/{ids}")
    public Result<String> delete(@PathVariable("ids")List<String> ids){
        iFloorInfo.delete(ids);
        return Result.success();
    }

}
