package com.ispydeer.DutyManager.security;

import com.ispydeer.DutyManager.services.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

/**
 * Security configuration class for the Duty Manager application.
 * Configures user details and security filter chain for handling authentication and authorization.
 */
@Configuration
public class SecurityConfig {

    /**
     * Creates an InMemoryUserDetailsManager with predefined users.
     *
     * @return an InMemoryUserDetailsManager containing user details for authentication
     */
    @Bean
    public InMemoryUserDetailsManager createUserManager() {
        UserDetails user1 = UserService.createNewUser("alexTaylor", "dummy");
        UserDetails user2 = UserService.createNewUser("jordanLee", "dummy");
        UserDetails user3 = UserService.createNewUser("caseyMorgan", "dummy");
        return new InMemoryUserDetailsManager(user1, user2, user3);
    }

    /**
     * Configures the security filter chain for the application.
     *
     * @param http the HttpSecurity object to configure security settings
     * @return the configured SecurityFilterChain
     * @throws Exception if an error occurs during configuration
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(auth -> auth
                .requestMatchers(HttpMethod.GET, "*/css/**").permitAll()
                .anyRequest().authenticated()
        );
        http.formLogin(withDefaults());
        http.logout(logout -> logout
                .logoutUrl("/logout")
                .logoutSuccessUrl("/")
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")
        );
        http.headers(header -> header.frameOptions(HeadersConfigurer.FrameOptionsConfig::sameOrigin));
        return http.build();
    }
}
