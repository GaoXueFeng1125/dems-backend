package edu.sugon.demsbackend.vo;

import edu.sugon.demsbackend.common.BasePageVo;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(name = "PermissionsInfoPageVo",title = "权限分页查询")
public class PermissionsInfoPageVo extends BasePageVo {
    @Schema(name = "permissionName",title = "权限名称")
    private String permissionName;
}
