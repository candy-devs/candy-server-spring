package candy.server.config;

import jdk.javadoc.doclet.Doclet;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
@EnableWebMvc
public class SwaggerConfig {

    @Bean
    public Docket swaggerAPI(){
        return new Docket(DocumentationType.OAS_30)
                .useDefaultResponseMessages(true)
                .select()
                .apis(RequestHandlerSelectors.basePackage("candy.server"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("swagger")
                .description("excute swagger")
                .version("1.0")
                .build();
    }
}