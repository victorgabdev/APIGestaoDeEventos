package com.victorgabriel.eventos.shared.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration  // Informa pro Spring que é uma class de configuracao
@EnableWebSecurity  // Informa que a classe de configuração é do Spring Security
public class SecurityConfig {

    @Bean  //
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests()
                .antMatchers(HttpMethod.POST, "/customers/").permitAll()
                .antMatchers(HttpMethod.POST, "/organizers/").permitAll()

                .and().addFilterBefore(new SecurityFilter(), UsernamePasswordAuthenticationFilter.class)
                ;

        return http.build();
    }
}
