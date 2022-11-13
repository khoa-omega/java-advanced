package com.vti.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class Swagger2Configuration {
    @Bean
    public Docket docket() {
        final Contact contact = new Contact(
                "Nguyễn Văn Khoa",
                "https://www.facebook.com/omegakhoa",
                "nvkhoa05@gmail.com"
        );
        final ApiInfo apiInfo = new ApiInfo(
                "KShop Application",
                "This is a final exam for Advanced Java course",
                "1.0.0",
                "https://github.com/khoa-omega/java-advanced",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0.html",
                Collections.emptyList()
        );
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo);
    }
}
