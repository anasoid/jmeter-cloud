package org.anasoid.jmeter.cloud.app.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.UserDetailsRepositoryReactiveAuthenticationManager
import org.springframework.security.config.Customizer
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity
import org.springframework.security.config.web.server.ServerHttpSecurity
import org.springframework.security.core.userdetails.MapReactiveUserDetailsService
import org.springframework.security.core.userdetails.ReactiveUserDetailsService
import org.springframework.security.core.userdetails.User
import org.springframework.security.web.server.SecurityWebFilterChain
import org.springframework.security.web.server.util.matcher.PathPatternParserServerWebExchangeMatcher


@Configuration
@EnableWebFluxSecurity
open class SecurityHttpConfig {


    @Bean
    fun filterChainSecurityApp(http: ServerHttpSecurity): SecurityWebFilterChain {
        http.securityMatcher(PathPatternParserServerWebExchangeMatcher("/app/**"))
            .authorizeExchange { authorize -> authorize.pathMatchers("/app/css/**").permitAll() }
            .authorizeExchange { authorize -> authorize.pathMatchers("/user/**").permitAll() }
            .httpBasic(Customizer.withDefaults())
            .authenticationManager(UserDetailsRepositoryReactiveAuthenticationManager(userDetailsService()))
        return http.build()
    }


    private fun userDetailsService(): ReactiveUserDetailsService {
        val userDetails = User
            .withUsername("user")
            .password("pass")
            .roles("USER")
            .build()
        return MapReactiveUserDetailsService(userDetails)
    }


}


