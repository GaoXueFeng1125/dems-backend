package edu.sugon.demsbackend.vo;


import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Tag(name = "用户登录")
public class LoginVo {
    @Schema(name = "userNo",title = "用户编号")
    private String userNo;
    @Schema(name = "password",title = "密码")
    private String password;


}
