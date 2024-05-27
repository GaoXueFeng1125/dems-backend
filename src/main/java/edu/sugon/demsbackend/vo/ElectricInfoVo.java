package edu.sugon.demsbackend.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Schema(name = "ElectricInfoVo", title = "电表信息")
public class ElectricInfoVo {
    @Schema(name = "id", title = "主键")
    private String id;
    @Schema(name = "power", title = "瞬时功率")
    private float power;
    @Schema(name = "meterNo", title = "电表编号")
    private String meterNo;
    @Schema(name = "remark",title = "备注")
    private String remark;
}
