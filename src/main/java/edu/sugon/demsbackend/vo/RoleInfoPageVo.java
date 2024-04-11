package edu.sugon.demsbackend.vo;

import edu.sugon.demsbackend.common.BasePageVo;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(name = "RoleInfoPageVo",title = "角色分页查询")
public class RoleInfoPageVo extends BasePageVo {
    @Schema(name = "roleName",title = "角色名称")
    private String roleName;
}
