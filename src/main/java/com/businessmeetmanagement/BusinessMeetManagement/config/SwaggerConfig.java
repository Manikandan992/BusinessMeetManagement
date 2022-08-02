package com.businessmeetmanagement.BusinessMeetManagement.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket businessMeetManagement(){
        Docket docket=new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
                .select().apis(RequestHandlerSelectors.basePackage("com.businessmeetmanagement.BusinessMeetManagement.controllers"))
                .build();
        return docket;
    }

    public ApiInfo apiInfo(){
        ApiInfo apiInfo = new ApiInfoBuilder().description("Business Meet Management")
                .contact(new Contact("Business Meet Management","http://www.fakeapi.com","fake@gmail.com"))
                .license("Customer License").licenseUrl("http://www.fakeapi.com")
                .build();
        return apiInfo;
    }
}
