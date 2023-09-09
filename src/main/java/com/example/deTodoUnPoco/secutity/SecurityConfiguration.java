package com.example.deTodoUnPoco.secutity;

import com.example.deTodoUnPoco.secutity.jwt.JwtAuthenticationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration  {


    private final JwtAuthenticationFilter jwtAuthenticationFilter;

   private final AuthenticationProvider authProvider;

    private static final String ROLE_ADMIN = "ADMIN";
    private static final String ROLE_USER = "USER";


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests((authz) -> authz
                        .requestMatchers("/user/**").permitAll()
                                .requestMatchers(HttpMethod.GET,"/product").permitAll()
                                .requestMatchers("/product/**").hasRole(ROLE_ADMIN)
                                //.anyRequest().authenticated()
                )
                .sessionManagement(sessionManager-> sessionManager
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authProvider)
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
        .build();
    }


}
