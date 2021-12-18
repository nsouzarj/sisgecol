package br.geral

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer
import org.springframework.context.annotation.ComponentScan
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.web.WebApplicationInitializer
import javax.servlet.FilterConfig
import javax.servlet.ServletException


@ComponentScan("br.controles","br.repositorios","br.servicos","br.geral")
@EnableJpaRepositories("br.repositorios")
@EntityScan(basePackages= arrayOf("br.entidades"))
@SpringBootApplication
open class SisgecolApplication : SpringBootServletInitializer() , WebApplicationInitializer


fun main(args: Array<String>) {
      runApplication<SisgecolApplication>(*args)
    //SpringApplication.run(SisgecolApplication::class.java, *args)
}
