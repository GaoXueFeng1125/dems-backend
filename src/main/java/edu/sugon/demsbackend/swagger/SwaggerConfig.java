package edu.sugon.demsbackend.swagger;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.core.customizers.GlobalOpenApiCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;

/**
 * Swagger配置
 */
@Configuration
@Slf4j
@RequiredArgsConstructor
public class SwaggerConfig {
    /**
     * 接口信息
     */
    @Bean
    public OpenAPI openAPI(){
        return new OpenAPI()
                .info(new Info()
                        .title("宿舍用电监管系统接口文档")
                        .version("0.0.1")
                )
                //配置全局鉴权参数Authorize
                .components(new Components()
                        .addSecuritySchemes(HttpHeaders.AUTHORIZATION,
                                new SecurityScheme()
                                        .name(HttpHeaders.AUTHORIZATION)
                                        .type(SecurityScheme.Type.APIKEY)
                                        .in(SecurityScheme.In.HEADER)));
    }
    @Bean
    public GlobalOpenApiCustomizer globalOpenApiCustomizer(){
        return openApi -> {
            if (openApi.getPaths() != null){
                openApi.getPaths().forEach((s,pathItem)->{
                    if (s.equals("/login")){
                        return;
                    }
                    pathItem.readOperations().forEach(operation -> operation.addSecurityItem(new
                            SecurityRequirement().addList(HttpHeaders.AUTHORIZATION))
                    );
                });
            }
        };
    }

}
