package br.utils

import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component
import org.springframework.web.servlet.config.annotation.EnableWebMvc
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport
import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.ApiInfo
import springfox.documentation.service.Contact
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2

@EnableWebMvc
@EnableSwagger2
@Component
class SwaggerConfiguratios : WebMvcConfigurationSupport() {
    override fun addResourceHandlers(registry: ResourceHandlerRegistry) {
        registry.addResourceHandler("swagger-ui.html")
            .addResourceLocations("classpath:/META-INF/resources/")
        registry.addResourceHandler("/webjars/**")
            .addResourceLocations("classpath:/META-INF/resources/webjars/")
    }

    @Bean
    fun api(): Docket {
        return Docket(DocumentationType.SWAGGER_2)
            .select().apis(RequestHandlerSelectors.any())
            .paths(PathSelectors.any()).build().apiInfo(apiInfo())
    }

    private fun apiInfo(): ApiInfo {
        return ApiInfoBuilder().title("** API DO SISGECOL COM TIMELYAF**")
            .description("Api com spring boot para o novo sistema de solicitaçãoes SISGECOL.")
            .termsOfServiceUrl("Licença Particular").license("Para uso de desenvolvimento.")
            .description("Banco de Dados PostgreSQL 11, Lombok, Spring Boot e Swagger")
            .version("1.0").contact(
                Contact(
                    "Nelson Seixas de souza",
                    "https://github.com/nsouzarj/apisisgecol",
                    "nsouzarj@outlook.com"
                )
            ).build()
    }
}