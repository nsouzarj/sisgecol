package br.geral

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.factory.PasswordEncoderFactories
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.web.servlet.ViewResolver
import org.springframework.web.servlet.view.InternalResourceViewResolver
import javax.sql.DataSource

@Configuration
@EnableWebSecurity(debug = false)
/**
 * Classe de segurança pra uso afins
 *
 * @author Nelson
 */
 open class SecurityConfig : WebSecurityConfigurerAdapter() {

      @Throws(Exception::class)

      //  http.cors().disable();
      override fun configure(http: HttpSecurity) {
          http.csrf().disable().authorizeRequests().
              antMatchers("/WEB-INF/views/","/webjars/**","/erro/**","/swagger-ui/**","/login/**","/js/**").permitAll().
              antMatchers("/menu/**","/bancas/**","/comarcas/**","/comarca","/uf/**","/tipos/**","/comarcapossui/**","/solicitacoes/**","/usuarios/**").
              hasAnyRole("USER","ADMIN").and().formLogin().loginPage("/login").loginProcessingUrl("/login").
              successForwardUrl("/menu").failureForwardUrl("/").failureUrl("/");
              //.and().authorizeRequests().antMatchers("/usuarios").hasAnyRole("ADMIN")
          http.cors().disable();
      }



    @Autowired
    val data: DataSource? = null

    @Autowired
    @Throws(Exception::class)
    override fun configure(builder: AuthenticationManagerBuilder)  {

        println("Entrei....")
//        builder.jdbcAuthentication().dataSource(data).passwordEncoder(BCryptPasswordEncoder())
//                .usersByUsernameQuery(
//                        "select emailprincipal, senha as password, ativo from usuario where emailprincipal=?")
//                .authoritiesByUsernameQuery(
//                        "select emailprincipal, senha as password, ativo  from usuario where emailprincipal=?")

         builder.inMemoryAuthentication()
         .withUser("admin").password(passwordEncoder()?.encode("admin")).roles("ADMIN").
             and()
             .withUser("user").password(passwordEncoder()?.encode("user")).roles("USER")

    }



    @Bean
    open fun viewResolver(): ViewResolver {
        val viewResolver = InternalResourceViewResolver()
        viewResolver.setPrefix("/WEB-INF/views/")
        viewResolver.setSuffix(".jsp")
        return viewResolver
    }


    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val password = "nso1810"
            val passwordEncoder: PasswordEncoder = BCryptPasswordEncoder()
            val encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder()
            println(BCryptPasswordEncoder().encode("nso1810"))
        }
    }

    @Bean
    open fun passwordEncoder(): BCryptPasswordEncoder? {
        return BCryptPasswordEncoder()
    }
}