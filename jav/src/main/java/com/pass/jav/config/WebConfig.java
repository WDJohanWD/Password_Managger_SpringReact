package com.pass.jav.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")  // Permitir todas las rutas
        .allowedOrigins("http://localhost:3000")  // Permitir solicitudes desde el frontend (localhost:3000)
        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")  // Permitir métodos específicos, incluyendo OPTIONS
        .allowedHeaders("*")  // Permitir todos los encabezados
        .allowCredentials(true);  // Permitir credenciales (cookies, autenticación)

    }
}
