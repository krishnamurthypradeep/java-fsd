package com.myapp.fsd.config;

import com.myapp.fsd.domain.Product;
import com.myapp.fsd.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AppConfig {

    @Bean
    CommandLineRunner loadSampleData(ProductRepository repository) {
        return args -> {
            if (repository.count() == 0) {
                repository.save(new Product(
                        "iPhone 16", 999.99, "Latest iPhone", true, 4.8, "https://example.com/iphone16.jpg"));
                repository.save(new Product(
                        "iPad Pro", 799.99, "Pro tablet", false, 4.5, "https://example.com/ipadpro.jpg"));
                repository.save(new Product(
                        "MacBook Pro", 1999.99, "M3 MacBook", true, 4.9, "https://example.com/macbookpro.jpg"));
            }
        };
    }


    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("*") // Or your frontend URL
                        .allowedMethods("*");
            }
        };
    }

}
