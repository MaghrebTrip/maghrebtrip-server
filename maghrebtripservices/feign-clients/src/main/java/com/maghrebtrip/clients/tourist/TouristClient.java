package com.maghrebtrip.clients.tourist;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@FeignClient(name = "tourist", url = "${clients.tourist.url}")
public interface TouristClient {

    @GetMapping(path = "/all")
    List<TouristResponse> getAllTourists();
}