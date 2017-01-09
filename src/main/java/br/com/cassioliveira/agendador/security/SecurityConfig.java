package br.com.cassioliveira.agendador.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 *
 * @author Cássio Oliveira
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public SystemUserDetailsService userDetailsService() {
        return new SystemUserDetailsService();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        JsfLoginUrlAuthenticationEntryPoint jsfLoginEntry = new JsfLoginUrlAuthenticationEntryPoint();
        jsfLoginEntry.setLoginFormUrl("/login.xhtml");
        jsfLoginEntry.setRedirectStrategy(new JsfRedirectStrategy());
        
        JsfAccessDeniedHandler jsfDeniedEntry = new JsfAccessDeniedHandler();
        jsfDeniedEntry.setLoginPath("/acesso-negado.xhtml");
        jsfDeniedEntry.setContextRelative(true);
        
        http//
            .csrf().disable()
            .headers().frameOptions().sameOrigin()
            .and()
                
        .authorizeRequests()//
                .antMatchers("/login.xhtml", "/error.xhtml", "/javax.faces.resource/**").permitAll()
                .antMatchers("/home.xhtml", "/acesso-negado.xhtml", "/Agendador/agendamento/listar-agendamentos-abertos.xhtml").authenticated()
                .antMatchers("/Agendador/usuario/**").hasRole("ADMINISTRADORES")
                .antMatchers("/Agendador/sala/**", "/Agendador/equipamento/**", "/Agendador/responsavel/**", "/Agendador/agendamento/**").hasAnyRole("SECRETARIAS", "COORDENACOES", "DIRECAO", "ADMINISTRADORES")
                .and()
                
        .formLogin()//
                .loginPage("/login.xhtml")
                .failureUrl("/login.xhtml?invalid=true")
                .and()
                
        .logout()//
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .and()
                
        .exceptionHandling()//
                .accessDeniedPage("/acesso-negado.xhtml")
                .authenticationEntryPoint(jsfLoginEntry)
                .accessDeniedHandler(jsfDeniedEntry);
    }
}
