package edu.sugon.demsbackend.controller;


import edu.sugon.demsbackend.common.BaseUtil;
import edu.sugon.demsbackend.common.PageResult;
import edu.sugon.demsbackend.common.Result;
import edu.sugon.demsbackend.entity.BuildInfo;
import edu.sugon.demsbackend.service.IBuildInfo;
import edu.sugon.demsbackend.service.impl.IBuildInfoImpl;
import edu.sugon.demsbackend.vo.BuildInfoPageVo;
import edu.sugon.demsbackend.vo.BuildInfoVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "楼栋信息")
@RequestMapping("/build")
public class BuildInfoController {
    @Resource
    private IBuildInfo iBuildInfo;

    @Operation(summary = "根据楼栋号与楼栋名称模糊查询分页")
    @Parameters({
            @Parameter(name = "current",description = "当前页",in = ParameterIn.QUERY),
            @Parameter(name = "pageSize",description = "每页条数",in = ParameterIn.QUERY),
            @Parameter(name = "buildingsNo",description = "楼栋号",in = ParameterIn.QUERY),
            @Parameter(name = "buildingsName",description = "楼栋名称",in = ParameterIn.QUERY)
    })
    @GetMapping("/page")
    public Result<PageResult<BuildInfo>> page(@Parameter(hidden = true)BuildInfoPageVo vo){
        return Result.success(iBuildInfo.page(vo));
    }
    @Operation(summary = "根据ID获取楼栋信息")
    @GetMapping("/{id}")
    public Result<BuildInfo> getById(@PathVariable("id") String id){
        BuildInfo info = iBuildInfo.getById(id);
        return Result.success(info);

    }
    @Operation(summary = "添加楼栋")
    @PostMapping()
    public Result<String> save(@RequestBody BuildInfoVo vo) throws Exception{
        if (!BaseUtil.isPositiveInt(vo.getBuildingsNo())){
            throw new Exception("楼栋号不能为空且只能为正整数!");
        }
        iBuildInfo.save(vo);
        return Result.success();
    }
    @Operation(summary = "修改楼栋")
    @PutMapping()
    public Result<String> update(@RequestBody BuildInfoVo vo) throws Exception{
        if (!BaseUtil.isPositiveInt(vo.getBuildingsNo())){
            throw new Exception("楼栋号只能为正整数!");
        }
        iBuildInfo.update(vo);
        return Result.success();
    }
    @Operation(summary = "根据ID批量删除楼栋信息")
    @DeleteMapping("/{ids}")
    public Result<String> delete(@PathVariable("ids") List<String> ids){
        iBuildInfo.delete(ids);
        return Result.success();
    }

}
