package com.maghrebtrip.clients.attraction;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "attraction", url = "${clients.attraction.url}")
public interface AttractionClient {

    @GetMapping(path = "/hotels/city={cityId}")
    List<HotelResponse> getHotelByCityId(@PathVariable("cityId") Integer cityId);

    @GetMapping(path = "/restaurants/city={cityId}")
    List<RestaurantResponse> getRestaurantByCityId(@PathVariable("cityId") Integer cityId);

    @GetMapping(path = "/monuments/city={cityId}")
    List<MonumentResponse> getMonumentByCityId(@PathVariable("cityId") Integer cityId);
}