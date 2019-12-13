package com.simulacro.config;

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

import static springfox.documentation.builders.PathSelectors.regex;


@Configuration //Anotación encargada de definir que la clase es una clase de configuración para el framework
@EnableSwagger2
public class SwaggerConfig {

    public class SwaggerConfiguration {
        // URL DE SWAGGER http://localhost:8090/swagger-ui.html
        @Bean // Anotación que marca como bean cada uno de los métodos de tal forma que esten disponibles para Spring
        public Docket api() {
            return new Docket(DocumentationType.SWAGGER_2)
                    .select()
                    .apis(RequestHandlerSelectors.any())
                    .paths(PathSelectors.ant("/api/**")) //paths que entregara para consultar swagger
                    .build()
                    .apiInfo(apiInfo()); //define la documentacion del servicio, informacion..
        }

        private ApiInfo apiInfo() {
            return new ApiInfo(
                    "API SIMULACRO",
                    "API SIMULACRO SWAGGER",
                    "v1.0",
                    " ",
                    new Contact("Guido Huechumilla","", "guido.huechumilla@outlook.com"),
                    "License of API", "API license URL", Collections.emptyList());
        }

    }
}
