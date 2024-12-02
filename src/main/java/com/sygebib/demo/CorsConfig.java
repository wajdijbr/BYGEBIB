package com.sygebib.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {

   @Bean
   public WebMvcConfigurer corsConfigurer() {
      return new WebMvcConfigurer() {
         @Override
         public void addCorsMappings(CorsRegistry registry) {
            registry.addMapping("/**") // Autoriser tous les chemins
                  .allowedOrigins("http://localhost:4200") // Origine Angular
                  .allowedMethods("*") // Méthodes HTTP autorisées
                  .allowedHeaders("*")
                  .allowCredentials(true); // Autoriser tous les en-têtes
         }
      };
   }
}
