package com.yuqi.alumnisystem.config;

/**
 * @author yuexi.guo
 * @date 2022/4/19 18:49
 */

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SpringFoxConfig {

    @Value("${spring.application.name}")
    private String applicationName;

    @Bean
    public Docket apiDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.yuqi.alumnisystem.controller"))
                .paths(PathSelectors.ant("/**"))
                .build()
                .apiInfo(getApiInfo());
    }

    private ApiInfo getApiInfo() {
        return new ApiInfoBuilder()
                .contact(new Contact(applicationName, "https://github.com/zzsleepzz", "919368809@qq.com"))
                .description(applicationName)
                .version("1.0")
                .build();
    }
}
