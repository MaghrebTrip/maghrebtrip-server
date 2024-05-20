package com.maghrebtrip.clients.city;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "city", url = "${clients.city.url}")
public interface CityClient {

    @GetMapping(path = "/all")
    List<CityResponse> getAllCities();
    @GetMapping(path = "/city/{id}")
    CityResponse getCity(@PathVariable("id") Integer id);
}
