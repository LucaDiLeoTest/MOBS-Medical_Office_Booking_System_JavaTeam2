package co.gruppo2.studiomedico.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

@Configuration
public class SpringFoxConfig {

    @Bean
    public Docket api(){

        ApiInfo apiInfo = new ApiInfo(
                "[MOBS]Medical_Office_Booking_System",
                "[MOBS]Medical_Office_Booking_System a booking back-end type software",
                "1.0.0",
                "https://en.wikipedia.org/wiki/MIT_License",
                new Contact("Mobs","https://mobsmanagment.co","mobs@mobsmanagment.co"),
                "MIT",
                "https://en.wikipedia.org/wiki/MIT_License",
                Collections.emptyList());

        return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.basePackage(
                        "co.gruppo2.studiomedico")).paths(PathSelectors.any()).build().apiInfo(apiInfo)

                .tags(new Tag("insert_txt","insert_txt"));
    }

}
