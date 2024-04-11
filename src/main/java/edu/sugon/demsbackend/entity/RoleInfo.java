package edu.sugon.demsbackend.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import edu.sugon.demsbackend.common.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(name = "RoleInfo",title = "角色信息")
@TableName("ROLE_INFO")
public class RoleInfo extends BaseEntity {
    @Schema(name = "roleName",title = "角色名称")
    private String roleName;
    @Schema(name = "remark",title = "备注")
    private String remark;

}
