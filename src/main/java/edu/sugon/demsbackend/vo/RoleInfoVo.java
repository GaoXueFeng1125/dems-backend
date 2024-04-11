package edu.sugon.demsbackend.vo;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Schema(name = "RoleInfoVo",title = "角色信息")
public class RoleInfoVo {
    @Schema(name = "id",title = "主键")
    private String id;
    @Schema(name = "roleName",title = "角色名称")
    private String roleName;
    @Schema(name = "remark",title = "备注")
    private String remark;

}
