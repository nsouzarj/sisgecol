package br.geral
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@ComponentScan("br.controles","br.repositorios","br.servicos","br.geral")
@EnableJpaRepositories("br.repositorios")
@EntityScan(basePackages= arrayOf("br.entidades"))
@SpringBootApplication
open class SisgecolApplication
fun main(args: Array<String>) {
    runApplication<SisgecolApplication>(*args)
    //SpringApplication.run(SisgecolApplication::class.java, *args)
}
