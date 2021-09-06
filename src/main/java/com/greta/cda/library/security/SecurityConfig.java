package com.greta.cda.library.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {
    private final PasswordEncoder passwordEncoder;

    @Bean
    protected UserDetailsService userDetailsService() {
        UserDetails userToto = User.builder()
                .username("toto")
                .password(passwordEncoder.encode("root"))
                .authorities("USER")
                .build();

        return new InMemoryUserDetailsManager(userToto);
    }
}
