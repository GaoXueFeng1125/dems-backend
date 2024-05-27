package edu.sugon.demsbackend.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import edu.sugon.demsbackend.common.BaseEntity;
import edu.sugon.demsbackend.enums.MaleFemaleEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(name = "DormInfo", title = "宿舍信息")
@TableName("DORM_INFO")
public class DormInfo extends BaseEntity {
    @Schema(name = "dormNo", title = "宿舍编号")
    private String dormNo;

    @Schema(name = "floorId", title = "楼层ID")
    private String floorId;

    @Schema(name = "meterId", title = "电表ID")
    private String meterId;

    @Schema(name = "dormCapacity", title = "宿舍容量")
    private Integer dormCapacity;

    @Schema(name = "dormNature", title = "宿舍性质")
    private MaleFemaleEnum dormNature;

    @Schema(name = "electricityBalance", title = "电费余额")
    private Double electricityBalance;

    @Schema(name = "dormTotal", title = "宿舍累积用电量")
    private Double dormTotal;

    @Schema(name = "remark", title = "备注")
    private String remark;
}
