package edu.sugon.demsbackend.config;

import org.springframework.web.filter.CorsFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
public class CorsConfig {
    @Bean
    public CorsFilter corsFilter(){
        CorsConfiguration corsConfig = new CorsConfiguration();
        //允许所有来源
        corsConfig.addAllowedOrigin("*");
        //允许所有http方法
        corsConfig.addAllowedMethod("*");
        // 允许所有HTTP标头 // 项目使用了 sa-token,并且是使用 token 前后端分离的方式，并不是使用 cookies传递用户token，所以要设置为false
        corsConfig.addAllowedHeader("*");
        // 允许携带身份信息（如Cookies）
        corsConfig.setAllowCredentials(false);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**",corsConfig);
        return new CorsFilter(source);
    }
}
