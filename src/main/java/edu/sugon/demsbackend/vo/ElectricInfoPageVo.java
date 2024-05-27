package edu.sugon.demsbackend.vo;

import edu.sugon.demsbackend.common.BasePageVo;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(name = "ElectricInfoPageVo", title = "电表信息分页查询")
public class ElectricInfoPageVo extends BasePageVo {

    @Schema(name = "power", title = "瞬时功率")
    private float power;

    @Schema(name = "meterNo", title = "电表编号")
    private String meterNo;
}
