/*
 * Copyright 2023-2023 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License")
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * @author : anas
 * Date :   08-Jun-2023
 */

package org.anasoid.jmeter.cloud.api.rest.config

import org.springframework.beans.factory.annotation.Autowired
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

/**
 * Security Config.
 */
@Configuration
@EnableWebFluxSecurity
open class SecurityHttpConfig {

    @Autowired
    private lateinit var moduleConfig: ModuleConfig

    /**
     * Main security config chain.
     */
    @Bean
    fun filterChainSecurityApp(http: ServerHttpSecurity): SecurityWebFilterChain {
        http.securityMatcher(PathPatternParserServerWebExchangeMatcher(moduleConfig.mapping + "/**"))
            .authorizeExchange { authorize -> authorize.pathMatchers(moduleConfig.mapping + "/css/**").permitAll() }
            .authorizeExchange { authorize -> authorize.pathMatchers("/user/**").permitAll() }
            .authorizeExchange { authorize -> authorize.pathMatchers(moduleConfig.mapping + "/**").authenticated() }
            .httpBasic(Customizer.withDefaults())
            .authenticationManager(UserDetailsRepositoryReactiveAuthenticationManager(userDetailsService()))
        return http.build()
    }

    private fun userDetailsService(): ReactiveUserDetailsService {
        val userDetails = User.withDefaultPasswordEncoder()
            .username("user")
            .password("pass")
            .roles("USER")
            .build()
        return MapReactiveUserDetailsService(userDetails)
    }
}
