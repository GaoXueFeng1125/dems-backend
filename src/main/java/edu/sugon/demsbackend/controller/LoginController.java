package edu.sugon.demsbackend.controller;

import cn.dev33.satoken.stp.StpUtil;
import edu.sugon.demsbackend.common.Result;
import edu.sugon.demsbackend.vo.LoginVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "登录")
public class LoginController {
    @Operation(summary = "登录")
    @PostMapping("/login")
    public Result<String> login(@RequestBody LoginVo vo){
        if ("admin".equals(vo.getUserNo())){
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
}
