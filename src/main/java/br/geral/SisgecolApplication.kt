package br.geral

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer
import org.springframework.context.annotation.ComponentScan
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.web.WebApplicationInitializer



@ComponentScan("br.controllers","br.repositories","br.services","br.geral")
@EnableJpaRepositories("br.repositories")
@EntityScan(basePackages= arrayOf("br.entityes"))
@SpringBootApplication
open class SisgecolApplication : SpringBootServletInitializer() , WebApplicationInitializer


fun main(args: Array<String>) {
      runApplication<SisgecolApplication>(*args)
    //SpringApplication.run(SisgecolApplication::class.java, *args)
}
