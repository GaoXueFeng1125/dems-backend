package edu.sugon.demsbackend.controller;

import edu.sugon.demsbackend.common.PageResult;
import edu.sugon.demsbackend.common.Result;
import edu.sugon.demsbackend.entity.PermissionsInfo;
import edu.sugon.demsbackend.service.IPermissionsInfo;
import edu.sugon.demsbackend.service.impl.IPermissionsInfoImpl;
import edu.sugon.demsbackend.vo.PermissionsInfoPageVo;
import edu.sugon.demsbackend.vo.PermissionsInfoVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "权限信息")
@RequestMapping("/permissions")
public class PermissionsInfoController {
    @Resource
    private IPermissionsInfo iPermissionsInfo;

    @Operation(summary = "根据权限名称模糊查询分页")
    @Parameters({
            @Parameter(name = "current",description = "当前页",in = ParameterIn.QUERY),
            @Parameter(name = "pageSize",description = "每页条数",in = ParameterIn.QUERY),
            @Parameter(name = "permissionsName",description = "权限名称",in = ParameterIn.QUERY)

    })
    @GetMapping("/page")
    public Result<PageResult<PermissionsInfo>> page(@Parameter(hidden = true)PermissionsInfoPageVo vo){
        return Result.success(iPermissionsInfo.page(vo));
    }

    @Operation(summary = "根据ID获取权限信息")
    @GetMapping("/{id}")
    public Result<PermissionsInfo> getById(@PathVariable("id") String id){
        PermissionsInfo info = iPermissionsInfo.getById(id);
        return Result.success(info);

    }
    @Operation(summary = "添加权限")
    @PostMapping()
    public Result<String> save(@RequestBody PermissionsInfoVo vo) throws Exception{
        iPermissionsInfo.save(vo);
        return Result.success();

    }
    @Operation(summary = "修改权限")
    @PutMapping()
    public Result<PermissionsInfo> update(@RequestBody PermissionsInfoVo vo) throws Exception{
        iPermissionsInfo.update(vo);
        return Result.success();
    }

    @Operation(summary = "根据ID批量删除权限信息")
    @DeleteMapping("/{ids}")
    public Result<String> delete(@PathVariable("ids")List<String> ids){
        iPermissionsInfo.delete(ids);
        return Result.success();
    }

}
