package edu.sugon.demsbackend.controller;

import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.ShearCaptcha;
import edu.sugon.demsbackend.common.Result;
import edu.sugon.demsbackend.vo.LoginVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.*;

@Getter
@Setter
@RestController
@Tag(name = "登录")
public class LoginController {

    private String verifyCode;
    @Operation(summary = "登录")
    @PostMapping("/login")
    public Result<String> login(@RequestBody LoginVo vo){
        if ("admin".equals(vo.getUserNo()) && vo.getVerifyCode().equals(this.verifyCode)){
            StpUtil.login("112");
            String tokenInfo = StpUtil.getTokenValue();
            return Result.success(tokenInfo);
        }
        return Result.error("登录失败");
    }
    @Operation(summary = "测试")
    @PostMapping("/test")
    public Result<String> test(){
        return Result.success(StpUtil.getLoginIdAsString());
    }


    @Operation(summary = "验证码")
    @GetMapping("/captcha")
    public Result<String> getCaptcha(){
        ShearCaptcha captcha = CaptchaUtil.createShearCaptcha(200,100,4,4);
        captcha.write("d:/shear.png");
        this.setVerifyCode(captcha.getCode());
        System.out.println(captcha.getCode());
        return Result.success("data:image/jpeg;base64," + captcha.getImageBase64());
    }
}
