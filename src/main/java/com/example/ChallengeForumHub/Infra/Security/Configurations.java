package com.example.ChallengeForumHub.Infra.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.http.HttpMethod;

@Configuration
@EnableWebSecurity
public class Configurations {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                .requestMatchers(HttpMethod.GET, "/topicos/**").permitAll()
                .requestMatchers(HttpMethod.POST, "/topicos/**").permitAll()
                .requestMatchers(HttpMethod.PUT, "/topicos/**").permitAll()
                .requestMatchers(HttpMethod.DELETE, "/topicos/**").permitAll()

                .requestMatchers(HttpMethod.GET, "/curso/**").permitAll()
                .requestMatchers(HttpMethod.POST, "/curso/**").permitAll()
                .requestMatchers(HttpMethod.PUT, "/curso/**").permitAll()
                .requestMatchers(HttpMethod.DELETE, "/curso/**").permitAll()

                .requestMatchers(HttpMethod.GET, "/perfil/**").permitAll()
                .requestMatchers(HttpMethod.POST, "/perfil/**").permitAll()
                .requestMatchers(HttpMethod.PUT, "/perfil/**").permitAll()
                .requestMatchers(HttpMethod.DELETE, "/perfil/**").permitAll()

                .requestMatchers(HttpMethod.GET, "/usuario/**").permitAll()
                .requestMatchers(HttpMethod.POST, "/usuario/**").permitAll()
                .requestMatchers(HttpMethod.PUT, "/usuario/**").permitAll()
                .requestMatchers(HttpMethod.DELETE, "/usuario/**").permitAll()
            )
            .httpBasic(basic -> {})
            .csrf(csrf -> csrf.disable());

        return http.build();
    }
}
