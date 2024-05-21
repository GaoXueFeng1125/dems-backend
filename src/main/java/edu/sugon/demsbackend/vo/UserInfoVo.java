package edu.sugon.demsbackend.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(name = "UserInfoVo",title = "用户信息")
public class UserInfoVo {
    @Schema(name = "id",title = "主键")
    private String id;
    @Schema(name = "userNo",title = "学号")
    private String userNo;
    @Schema(name = "userPwd",title = "密码")
    private String userPwd;
    @Schema(name = "name",title = "姓名")
    private String name;
    @Schema(name = "sex",title = "性别")
    private String sex;
    @Schema(name = "dormId",title = "宿舍ID")
    private String dormId;
    @Schema(name = "phoneNum",title = "手机号")
    private String phoneNum;
    @Schema(name = "email",title = "邮箱")
    private String email;
}
