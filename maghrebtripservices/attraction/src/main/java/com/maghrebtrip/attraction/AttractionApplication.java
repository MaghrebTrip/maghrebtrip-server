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
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.stereotype.Component;

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
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(
        basePackages = "com.maghrebtrip.clients"
)
@PropertySources({
        @PropertySource("classpath:clients-${spring.profiles.active}.properties")
})
public class AttractionApplication {
    public static void main(String[] args) {
        SpringApplication.run(AttractionApplication.class, args);
    }
}
