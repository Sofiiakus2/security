package edu.kushnirenko.security25.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

/*
  @author   Sofiia
  @project   security25
  @class  SecurityConfig
  @version  1.0.0
  @since 20.03.2025 - 15.59
*/
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(
                        req -> req
                                .requestMatchers("/index.html").permitAll()
                                .requestMatchers("/api/v1/books/admin").hasRole("ADMIN")
                                .requestMatchers("/api/v1/books/superAdmin").hasRole("SUPERADMIN")
                                .requestMatchers("/api/v1/books/user").hasRole("USER")
                                .anyRequest().authenticated())
                .httpBasic(Customizer.withDefaults());

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails admin = User.withUsername("admin")
                .password(passwordEncoder().encode("admin"))
                .roles("ADMIN")
                .build();

        UserDetails user = User.withUsername("user")
                .password(passwordEncoder().encode("user"))
                .roles("USER")
                .build();

        UserDetails superAdmin = User.withUsername("superAdmin")
                .password(passwordEncoder().encode("superAdmin"))
                .roles("SUPERADMIN")
                .build();

        return new InMemoryUserDetailsManager(admin, user, superAdmin);
    }

}
