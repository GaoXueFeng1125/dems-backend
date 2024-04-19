package edu.sugon.demsbackend.vo;

import edu.sugon.demsbackend.common.BasePageVo;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(name = "BuildInfoPageVo",title = "楼栋分页查询")
public class BuildInfoPageVo extends BasePageVo {
    @Schema(name = "buildingsNo",title = "楼栋号")
    private String buildingsNo;
    @Schema(name = "buildingsName",title = "楼栋名称")
    private String buildingsName;

}
