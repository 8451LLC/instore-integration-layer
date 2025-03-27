package com.e451.instoreintegrationlayer.webhook.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Value("${info.app.name}")
    private String appName;

    @Value("${info.app.description}")
    private String appDescription;

    @Value("${info.app.version}")
    private String appVersion;

    @Bean
    public OpenAPI openAPI() {
        final String securitySchemaName = "bearerAuth";
        return new OpenAPI()
//                .addSecurityItem(new SecurityRequirement().addList(securitySchemaName))
//                .components(
//                        new Components()
//                                .addSecuritySchemes(
//                                        securitySchemaName,
//                                        new SecurityScheme()
//                                                .name(securitySchemaName)
//                                                .type(SecurityScheme.Type.HTTP)
//                                                .scheme("bearer")
//                                                .bearerFormat("JWT")))
                .info(
                        new Info()
                                .title(appName)
                                .description(appDescription)
                                .version(appVersion)
                                .contact(
                                        new Contact()
                                                .email(
                                                        "Offsite_InStore_Incentives_DL@8451.com")
                                                .name("Offsite, InStore, Incentives")));
    }
}
