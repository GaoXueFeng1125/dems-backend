package edu.sugon.demsbackend.controller;


import edu.sugon.demsbackend.common.PageResult;
import edu.sugon.demsbackend.common.Result;
import edu.sugon.demsbackend.entity.RoleInfo;
import edu.sugon.demsbackend.service.impl.IRoleInfoImpl;
import edu.sugon.demsbackend.vo.RoleInfoPageVo;
import edu.sugon.demsbackend.vo.RoleInfoVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "角色信息")
@RequestMapping("/role")
public class RoleInfoController {
    @Resource
    private IRoleInfoImpl iRoleInfo;

    @Operation(summary = "根据角色名称模糊查询分页")
    @Parameters({
            @Parameter(name = "current",description = "当前页",in = ParameterIn.QUERY),
            @Parameter(name = "pageSize",description = "每页条数",in = ParameterIn.QUERY),
            @Parameter(name = "roleName",description = "角色名称",in = ParameterIn.QUERY),
    })
    @GetMapping("/page")
    public Result<PageResult<RoleInfo>> page(@Parameter(hidden = true)RoleInfoPageVo vo){
        return Result.success(iRoleInfo.page(vo));
    }

    @Operation(summary = "根据ID获取角色信息")
    @GetMapping("/{id}")
    public Result<RoleInfo> getById(@PathVariable("id") String id){
        RoleInfo info = iRoleInfo.getById(id);
        return Result.success(info);
    }

    @Operation(summary = "添加角色")
    @PostMapping()
    public Result<String> save(@RequestBody RoleInfoVo vo) throws Exception {
        iRoleInfo.save(vo);
        return Result.success();
    }


    @Operation(summary = "修改角色")
    @PutMapping()
    public Result<String> update(@RequestBody RoleInfoVo vo) throws Exception {
        iRoleInfo.update(vo);
        return Result.success();

    }

    @Operation(summary = "根据ID批量删除角色信息")
    @DeleteMapping("/{ids}")
    public Result<String> delete(@PathVariable("ids")List<String> ids){
        iRoleInfo.delete(ids);
        return Result.success();
    }


}
