package com.teste.solution.infra.swagger;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
public class SwaggerApiConfigurations {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .addSecurityItem(new SecurityRequirement().addList("bearer-key"))
                .components(new Components().addSecuritySchemes("bearer-key",
                        new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("bearer").bearerFormat("JWT")))
                .info(new Info()
                        .title("Back-end Teste - Solution TI")
                        .description("API para teste do processo seletivo da empresa Solution TI.")
                        .termsOfService("")
                        .contact(
                                new Contact()
                                        .name("Gabriel Toyo [Desenvolvedor]")
                                        .email("ggabrieltoyo@gmail.com.br")
                                        .url("https://www.linkedin.com/in/gabriel-alves-toyo-709b72205/"))
                        .license(new License()
                                .name("MIT License")
                                .url("https://opensource.org/licenses/MIT"))
                        .version("1.0.0")
                        .extensions(Map.of("x-empresa", "Solution TI"))
                );
    }
}
