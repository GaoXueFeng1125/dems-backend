package edu.sugon.demsbackend.vo;

import edu.sugon.demsbackend.common.BasePageVo;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@Schema(name = "FloorInfoPageVo",title = "楼层信息分页查询")
public class FloorInfoPageVo extends BasePageVo {
    @Schema(name = "floorNo",title = "楼层号")
    private String floorNo;
    @Schema(name = "buildingsId",title = "所属楼栋")
    private String buildingsId;
}
