package com.curso.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfiguration {

    @Bean
    public GroupedOpenApi publicApi(){
        return GroupedOpenApi.builder().group("suporteOs2024")
                .pathsToMatch("/**").packagesToScan("com.curso.resources")
                .build();
    }

    @Bean
    public OpenAPI customAPI(){
        return new OpenAPI().info(new Info().title("Suporte OS 2024").description("Documentação do Suporte OS 2024")
                .version("1.0").contact(new Contact().name("FEF 2024").url("https://github.com/JoiceBergamin").email("joicenafef@gmail.com")));
    }
}

