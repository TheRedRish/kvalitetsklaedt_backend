package dk.kvalitetsklaedt.backend.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*") // or "*" for testing
                .allowedMethods("OPTIONS", "POST", "GET", "PUT", "DELETE")
                .allowedHeaders("*");
    }
}
