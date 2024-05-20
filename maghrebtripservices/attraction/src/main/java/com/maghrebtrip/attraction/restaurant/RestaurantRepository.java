package com.maghrebtrip.attraction.restaurant;

import java.util.List;

import com.maghrebtrip.attraction.hotel.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository <Restaurant, Integer> {

    Restaurant findByName(String name);
    List<Restaurant> findByLocation(String location);
    List<Restaurant> findByCityId(Integer cityId);
}
