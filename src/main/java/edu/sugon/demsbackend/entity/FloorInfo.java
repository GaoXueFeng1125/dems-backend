package edu.sugon.demsbackend.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import edu.sugon.demsbackend.common.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Schema(name = "FloorInfo",title = "楼层信息")
@TableName("FLOOR_INFO")
public class FloorInfo extends BaseEntity {
    @Schema(name = "floorNo",title = "楼层号")
    private String floorNo;
    @Schema(name = "buildingsId",title = "所属楼栋")
    private String buildingsId;
    @TableField(exist = false)
    @Schema(name = "buildingsNo",title = "所属楼栋")
    private String buildingsNo;
    @Schema(name = "remark",title = "备注")
    private String remark;


}
