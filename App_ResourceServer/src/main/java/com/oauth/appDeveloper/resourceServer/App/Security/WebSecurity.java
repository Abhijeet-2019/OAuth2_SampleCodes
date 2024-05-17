package com.oauth.appDeveloper.resourceServer.App.Security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@Slf4j
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class WebSecurity {

    // This method is used to configure the Http security for the application
    // This lines bellow are used to authenticate any Http request
    // that has a valid token.
    @Bean
    public SecurityFilterChain configure(HttpSecurity httpSecurity) throws Exception {

        log.info("Called from the Web security Filter");
        JwtAuthenticationConverter jwtAuthenticationConverter = new JwtAuthenticationConverter();
        jwtAuthenticationConverter.setJwtGrantedAuthoritiesConverter(new KeycloakRoleConverter());

        httpSecurity.authorizeHttpRequests(auth -> {
            auth.antMatchers(HttpMethod.GET,"/users/permitMe")
                    .permitAll()
                    .antMatchers(HttpMethod.GET, "/users/**")
                    .hasRole("appDeveloper")
//                    .antMatchers(HttpMethod.GET, "/admin/**")  // we can add this using @Secured method also
//                    .hasRole("adminUser1")

                    .anyRequest().authenticated();
        }).oauth2ResourceServer(oauth2 -> oauth2.jwt(jwt -> {
            jwt.jwtAuthenticationConverter(jwtAuthenticationConverter);
        }));
        return httpSecurity.build();
    }
}
