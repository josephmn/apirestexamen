package com.crudusuario.apirestexamen.config;
 
import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
 
import springfox.documentation.builders.PathSelectors;
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
	public Docket apiDocket() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.crudusuario.apirestexamen.controller"))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(getApiInfo());
	}
	
	private ApiInfo getApiInfo() {
		return new ApiInfo(
				"API RestFull Usuario",
				"Registrar Usuario",
				"v1.0",
				"http://example.com/usuario",
				new Contact("Joseph Magallanes", "https://www.linkedin.com/in/joseph-magallanes-nolazco/", "josephcarlos.jcmn@gmail.com.com"),
				"ABC123",
				"http://example.com/licenseUrl",
				Collections.emptyList()
				);
	}
}
