package com.tareaflow.config;

import com.tareaflow.security.JwtAuthFilter;
import jakarta.servlet.Filter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SecurityConfig {

    @Bean
    public FilterRegistrationBean<Filter> jwtFilter(JwtAuthFilter filter) {
        FilterRegistrationBean<Filter> registration = new FilterRegistrationBean<>();
        registration.setFilter(filter);

        // ✅ Rutas protegidas con JWT
        registration.addUrlPatterns(
                "/api/users/me",
                "/api/boards",
                "/api/boards/*",
                "/api/tasks",
                "/api/tasks/*",
                // Protege todas las rutas bajo /api/columns/ incluyendo {columnId}/tasks
                "/api/columns/*"
        );

        return registration;
    }
}
