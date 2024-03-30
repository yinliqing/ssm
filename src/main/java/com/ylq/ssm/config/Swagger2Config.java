package com.ylq.ssm.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.mvc.method.RequestMappingInfoHandlerMapping;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableWebMvc
@EnableSwagger2
@ComponentScan(basePackages = "com.ylq.ssm") //要扫描的包路径
public class Swagger2Config extends WebMvcConfigurationSupport{
	// http://127.0.0.1:8080/ssm/swagger-ui.html
	// http://127.0.0.1:8080/ssm/v2/api-docs
	@Bean
	public Docket createRestApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.any())
                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
             // .apis(RequestHandlerSelectors.basePackage("com.ylq.ssm"))
                .paths(PathSelectors.any()) // 对所有路径进行监控
				.build()
			 // .pathMapping("/swagger") // 方法的url映射路径
				.apiInfo(webApiInfo());
	}
	
	@Bean
	public ApiInfo webApiInfo(){

        return new ApiInfoBuilder()
                .title("RESTful API文档")
                .description("本文档描述了RESTful API接口定义")
                .version("1.0")
                .contact(new Contact("java", "http://www.yinliqing.com", "76264809@qq.com"))
                .build();
    }
	
	@Bean
    public RequestMappingInfoHandlerMapping requestMapping(){
        return new RequestMappingHandlerMapping();
    }

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
}
