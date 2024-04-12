package edu.sugon.demsbackend.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import edu.sugon.demsbackend.common.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(name = "PermissionsInfo",title = "权限信息")
@TableName("PERMISSIONS_INFO")
public class PermissionsInfo extends BaseEntity {
    @Schema(name = "permissionName",title = "权限名称")
    private String permissionName;
    @Schema(name = "permissionsType",title = "权限类型")
    private String permissionType;
    @Schema(name = "route",title = "路由地址")
    private String route;
    @Schema(name = "remark",title = "备注")
    private String remark;


}
