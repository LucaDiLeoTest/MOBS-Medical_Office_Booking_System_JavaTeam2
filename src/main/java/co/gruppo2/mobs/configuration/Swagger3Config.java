package co.gruppo2.mobs.configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Swagger3Config {
    @Bean
    GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("Develhope-JavaGruppo2")
                .pathsToMatch("/api/**")
                .packagesToScan("co.gruppo2.mobs")
                .build();
    }

    @Bean
    OpenAPI jlyShopOpenApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("[MOBS]Medical Office Booking System API")
                        .description("Spring medical booking sample application")
                        .version("v0.0.1")
                        .license(new License().name("Apache 2.0").url("http://springdoc.org")))
                .externalDocs(new ExternalDocumentation()
                        .description("SpringDoc Wiki Documentation")
                        .url("https://springdoc.org/v2"));
    }

}