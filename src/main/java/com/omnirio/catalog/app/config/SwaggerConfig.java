package com.omnirio.catalog.app.config;

import org.springframework.context.annotation.Bean;    
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@ComponentScan("com.omnirio.catalog.app.config")
@EnableSwagger2
public class SwaggerConfig extends WebMvcConfigurationSupport {

    @Bean
    public Docket apiDocket() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.basePackage("com.omnirio.catalog.app.api"))
                .paths(regex("/api.*")).build().apiInfo(metaData());
    }


    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

    
    private ApiInfo metaData() {
        return new ApiInfoBuilder()
                .title("Omnirio's Product Catalog API Documentation.")
                .description("This API provides endpoints for omnirio's catalog management platform.")
                .version("1.0.0")
                .license("Omnirio Tech License Version 1.0")
                .contact(new Contact("Earnest Suru Erihbra", "https://linkedin.com/earnest-suru/", "serihbrah@gmail.com"))
                .build();
    }
    
    
}
