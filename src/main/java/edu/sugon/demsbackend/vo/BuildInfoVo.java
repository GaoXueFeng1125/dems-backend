package edu.sugon.demsbackend.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(name = "BuildInfoVo",title = "楼栋信息")
public class BuildInfoVo{
    @Schema(name = "id",title = "主键")
    private String id;
    @Schema(name = "buildingsNo",title = "楼栋号")
    private String buildingsNo;
    @Schema(name = "buildingsName",title = "楼栋名称")
    private String buildingsName;
    @Schema(name = "remark",title = "备注")
    private String remark;
}
