package br.geral

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.factory.PasswordEncoderFactories
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.servlet.ViewResolver
import org.springframework.web.servlet.view.InternalResourceViewResolver
import javax.servlet.FilterConfig
import javax.servlet.ServletException
import javax.sql.DataSource
import kotlin.jvm.Throws

@Configuration
//@EnableWebSecurity(debug = false)
//@EnableGlobalMethodSecurity(prePostEnabled = false)
//@ComponentScan(basePackages={"br.eti.nsouza.config";"br.eti.nsouza.entidades","br.eti.nsouza.controle","br.eti.nsouza.repositorios","br.eti.nsouza.geral"]})
// @Configuration
/**
 * Classe de segurança pra uso afins
 *
 * @author Nelson
 */
 open class SecurityConfig : WebSecurityConfigurerAdapter() {

    var encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder()!!
    var encoder1 = BCryptPasswordEncoder()

    @Throws(Exception::class)
    override  fun configure(http: HttpSecurity) {

   //E  um teste
        // http.csrf().disable().authorizeRequests().antMatchers("/login","/resources/**",
        // "/webjars/**","/erro/**").permitAll().anyRequest().authenticated().and().httpBasic();
        println("Sistema inicializado !!!!")
        // http.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
        //http.csrf().disable().authorizeRequests().antMatchers(HttpMethod.GET,"/**").permitAll();

        http.csrf().disable().authorizeRequests().antMatchers(HttpMethod.GET, "/webjars/**","/erro/**","/login","/uf/**", "/tipos/**", "/solicitacao/**", "/status/**", "/comarcapossui/**",
                "/usuarios/**", "/swagger-ui/**", "/colaborador/**", "/bancas/**", "/comarca/**", "/comarcas/**", "/**", "/").permitAll()

        http.cors()
    }

    @Autowired
    val data: DataSource? = null

    @Autowired
    @Throws(Exception::class)
    override fun configure(builder: AuthenticationManagerBuilder) {

        println("Entrei....")
        builder.jdbcAuthentication().dataSource(data).passwordEncoder(BCryptPasswordEncoder())
                .usersByUsernameQuery(
                        "select emailprincipal, senha as password, ativo from usuario where emailprincipal=?")
                .authoritiesByUsernameQuery(
                        "select emailprincipal, senha as password, ativo  from usuario where emailprincipal=?")

         builder.inMemoryAuthentication()
         .withUser("tim").password("123").roles("ADMIN") .and()
         .withUser("nsouzarj@bol.com.br").password(encoder.encode("nso1810")).roles("USER");
    }

    @Bean
     open fun  passwordEncoder(): PasswordEncoder {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder()
    }

    @Bean
    open fun viewResolver(): ViewResolver {
        val viewResolver = InternalResourceViewResolver()
        viewResolver.setPrefix("/WEB-INF/views/")
        viewResolver.setSuffix(".jsp")
        return viewResolver
    }

    @Bean
    @Throws(Exception::class)
    override fun authenticationManagerBean(): AuthenticationManager {
        return super.authenticationManagerBean()
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
}