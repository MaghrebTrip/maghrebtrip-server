package com.maghrebtrip.city;

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
    private CityService cityService;

    @Override
    public void run(String... args) {
        cityService.loadCityDataFromCSV();
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
public class CityApplication  {
    public static void main(String[] args) {
        SpringApplication.run(CityApplication.class, args);
    }
}
