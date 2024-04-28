package edu.sugon.demsbackend.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;
@Getter
@Setter
@Schema(name = "FloorInfo",title = "楼层信息")
public class FloorInfoVo {
    @Schema(name = "id",title = "主键")
    private String id;
    @Schema(name = "floorNo",title = "楼层号")
    private String floorNo;
    @Schema(name = "buildingsId",title = "所属楼栋")
    private String buildingsId;
    @Schema(name = "remark",title = "备注")
    private String remark;

}
