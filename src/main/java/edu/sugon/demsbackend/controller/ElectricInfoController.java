package edu.sugon.demsbackend.controller;

import edu.sugon.demsbackend.common.PageResult;
import edu.sugon.demsbackend.common.Result;
import edu.sugon.demsbackend.entity.ElectricInfo;
import edu.sugon.demsbackend.service.IElectricInfo;
import edu.sugon.demsbackend.vo.ElectricInfoPageVo;
import edu.sugon.demsbackend.vo.ElectricInfoVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "电表信息")
@RequestMapping("/electric")
public class ElectricInfoController {
    @Resource
    private IElectricInfo iElectricInfo;

    @Operation(summary = "根据电表编号模糊查询分页")
    @Parameters({
            @Parameter(name = "current",description = "当前页",in = ParameterIn.QUERY),
            @Parameter(name = "pageSize",description = "每页条数",in = ParameterIn.QUERY),
            @Parameter(name = "meterNo",description = "电表编号",in = ParameterIn.QUERY),
    })
    @GetMapping("/page")
    public Result<PageResult<ElectricInfo>> page(@Parameter(hidden = true) ElectricInfoPageVo vo) {
        return Result.success(iElectricInfo.page(vo));
    }

    @Operation(summary = "根据ID获取电表信息")
    @GetMapping("/{id}")
    public Result<ElectricInfo> getById(@PathVariable("id") String id) {
        ElectricInfo info = iElectricInfo.getById(id);
        return Result.success(info);
    }

    @Operation(summary = "添加电表信息")
    @PostMapping()
    public Result<String> save(@RequestBody ElectricInfoVo vo) throws Exception {
        iElectricInfo.save(vo);
        return Result.success();
    }

    @Operation(summary = "修改电表信息")
    @PutMapping()
    public Result<String> update(@RequestBody ElectricInfoVo vo) throws Exception {
        iElectricInfo.update(vo);
        return Result.success();
    }

    @Operation(summary = "根据ID批量删除电表信息")
    @DeleteMapping("/{ids}")
    public Result<String> delete(@PathVariable("ids") List<String> ids) {
        iElectricInfo.delete(ids);
        return Result.success();
    }
}
