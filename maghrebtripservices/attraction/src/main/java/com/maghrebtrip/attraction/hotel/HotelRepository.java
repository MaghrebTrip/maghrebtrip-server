package com.maghrebtrip.attraction.hotel;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HotelRepository extends JpaRepository <Hotel, Integer> {

    Hotel findByName(String name);
    List<Hotel> findByLocation(String location);
    List<Hotel> findByCityId(Integer cityId);
}
