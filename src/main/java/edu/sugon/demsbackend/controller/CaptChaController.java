package edu.sugon.demsbackend.controller;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.ShearCaptcha;


import edu.sugon.demsbackend.vo.LoginVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@Getter
@Setter
@Tag(name = "验证码测试接口")
@RestController
public class CaptChaController {
    private String verifyCode;
//    @Operation(summary = "验证码")
//    @PostMapping("/captcha")
//    public String getCaptcha(){
//        ShearCaptcha captcha = CaptchaUtil.createShearCaptcha(200,100,4,4);
//        captcha.write("d:/shear.png");
//        this.setVerifyCode(captcha.getCode());
//        System.out.println(captcha.getCode());
//        return "data:image/jpeg;base64," + captcha.getImageBase64();
////        return captcha.getImage();
//    }

    @Operation(summary = "验证")
    @PostMapping("/verify")
    public boolean verifyCap(@RequestBody LoginVo vo){
        if (vo.getVerifyCode().equals(this.verifyCode)){
            return true;
        }else {
            return false;
        }
    }

}
