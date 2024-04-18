package com.maghrebtrip.attraction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AttractionApplication {
    public static void main(String[] args) {
        SpringApplication.run(AttractionApplication.class, args);
    }
}
