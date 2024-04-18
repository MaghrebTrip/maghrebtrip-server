package com.maghrebtrip.city;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.stereotype.Component;

@Component
class MyComponent implements CommandLineRunner {

    @Autowired
    private CityService cityService;

    @Override
    public void run(String... args) {
        cityService.loadCityDataFromCSV();
    }
}

@SpringBootApplication
@EnableDiscoveryClient
public class CityApplication  {
    public static void main(String[] args) {
        SpringApplication.run(CityApplication.class, args);
    }
}
