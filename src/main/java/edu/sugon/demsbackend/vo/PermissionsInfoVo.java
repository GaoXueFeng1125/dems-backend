package edu.sugon.demsbackend.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(name = "PermissionsInfoVo",title = "权限信息")
public class PermissionsInfoVo {
    @Schema(name = "id",title = "主键")
    private String id;
    @Schema(name = "permissionName",title = "权限名称")
    private String permissionName;
    @Schema(name = "permissionType",title = "权限类型")
    private String permissionType;
    @Schema(name = "route",title = "路由地址")
    private String route;
    @Schema(name = "remark",title = "备注")
    private String remark;
}
