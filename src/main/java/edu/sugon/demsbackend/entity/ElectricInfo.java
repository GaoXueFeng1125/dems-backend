package edu.sugon.demsbackend.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import edu.sugon.demsbackend.common.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(name = "ElectricInfo",title = "电表信息")
@TableName("ELECTRIC_METER_INFO")
public class ElectricInfo extends BaseEntity {
    @Schema(name = "power", title = "瞬时功率")
    private float power;
    @Schema(name = "meterNo", title = "电表编号")
    private String meterNo;
    @Schema(name = "remark",title = "备注")
    private String remark;
}
