package com.orange5.transacao.security;

import org.springframework.context.annotation.Configuration;
// import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;

/**
 * SecurityConfiguration
 */

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests(authorizeRequest -> authorizeRequest
                .anyRequest().authenticated())
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt);

    }
    // .antMatchers(HttpMethod.GET, "/actuator/**").permitAll()
    // .antMatchers(HttpMethod.GET, "/cartoes/{cardId}/transacoes").hasAuthority("SCOPE_transactions:read")
}
