package me.jerry.backendtddex.infrastructure.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // url: 1) "/**" for all, 2) "/some-path/**" for /some-path and all
                .allowedOrigins("*") // origin: 1) *: allow all, 2) http://localhost:8080, http://localhost:8081 - specific host
                .allowedMethods("GET", "POST", "PUT", "DELETE", "PATCH", "HEAD", "OPTIONS");
    }
}
