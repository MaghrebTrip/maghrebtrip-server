package com.maghrebtrip.attraction;

import com.maghrebtrip.attraction.hotel.HotelService;
import com.maghrebtrip.attraction.monument.MonumentService;
import com.maghrebtrip.attraction.restaurant.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.stereotype.Component;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;
import java.util.Collections;

@Component
class DataLoader implements CommandLineRunner {

    @Autowired
    private HotelService hotelService;

    @Autowired
    private MonumentService monumentService;

    @Autowired
    private RestaurantService restaurantService;

    @Override
    public void run(String... args) {
        hotelService.loadHotelsDataFromCSV();
        restaurantService.loadRestaurantsDataFromCSV();
        monumentService.loadMonumentsDataFromCSV();
    }
}

@Configuration
class CorsConfig {

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        // Don't do this in production, use a proper list of allowed origins
        config.setAllowedOrigins(Collections.singletonList("http://localhost:5173/"));
        config.setAllowedHeaders(Arrays.asList("Origin", "Content-Type", "Accept"));
        config.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "OPTIONS", "DELETE", "PATCH"));
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
}

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.maghrebtrip.clients")
@PropertySources({
        @PropertySource("classpath:clients-${spring.profiles.active}.properties")
})
public class AttractionApplication {
    public static void main(String[] args) {
        SpringApplication.run(AttractionApplication.class, args);
    }
}
