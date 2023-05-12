package com.salomao.springsecurityexample.docs;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.ApiKeyVehicle;
import springfox.documentation.swagger.web.SecurityConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;

@Configuration
@EnableSwagger2
public class BaseSwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.salomao.springsecurityexample.user.endpoint.controller"))
                .paths(PathSelectors.any())
                .build().apiInfo(metaData());
    }

    private ApiInfo metaData() {
        return new ApiInfoBuilder()
                .title("Here's is another awesome apirest")
                .description("SpringSecurity + JWT")
                .version("1.0")
                .contact(new Contact("Salomao Batista", "http://linkedin.com/in/salomao123", "salomaum.batiata@gmail.com"))
                .license("Private stuff bro")
                .licenseUrl("http://salomaodev")
                .build();

    }

    @Bean
    public SecurityConfiguration security() {
        return new SecurityConfiguration(null, null, null, null, "Bearer access_token", ApiKeyVehicle.HEADER, "Authorization", ",");
    }

    private springfox.documentation.spi.service.contexts.SecurityContext securityContext() {
        return springfox.documentation.spi.service.contexts.SecurityContext.builder()
                .securityReferences(Arrays.asList(defaultAuth()))
                .forPaths(PathSelectors.regex("/api/.*")) // Update with your API paths
                .build();
    }

    private SecurityReference defaultAuth() {
        return SecurityReference.builder()
                .reference("Authorization")
                .scopes(new AuthorizationScope[0])
                .build();
    }

    private SecurityScheme apiKey() {
        return new ApiKey("Bearer Token", "Authorization", "header");
    }
}
