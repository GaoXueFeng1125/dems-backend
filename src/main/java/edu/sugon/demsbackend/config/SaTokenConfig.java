package edu.sugon.demsbackend.config;

import cn.dev33.satoken.interceptor.SaInterceptor;
import cn.dev33.satoken.jwt.StpLogicJwtForStateless;
import cn.dev33.satoken.stp.StpLogic;
import cn.dev33.satoken.stp.StpUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SaTokenConfig implements WebMvcConfigurer {
    //Sa-Token 整合 jwt (Stateless 无状态模式)
    @Bean
    public StpLogic getStpLogicJwt(){
        return new StpLogicJwtForStateless();
    }
    //注册 Sa-Token 拦截器，打开注解式鉴权功能
    @Override
    public void addInterceptors(InterceptorRegistry registry){
        //注册 Sa-Token 拦截器，校验规则为 StpUtil.checkLogin() 登录校验。
        registry.addInterceptor(new SaInterceptor(handle ->
                StpUtil.checkLogin()))
                .addPathPatterns("/**")
                .excludePathPatterns(
                        "/login"
                        ,"/swagger/**"
                        ,"/swagger-ui.html"
                        , "/webjars/**"
                        , "/v3/**"
                        , "/swagger-resources/**"
                        , "/doc.html");
    }
}
