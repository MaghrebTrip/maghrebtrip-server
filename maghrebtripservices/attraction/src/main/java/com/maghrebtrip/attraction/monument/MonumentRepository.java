package com.maghrebtrip.attraction.monument;

import com.maghrebtrip.attraction.hotel.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MonumentRepository extends JpaRepository<Monument, Integer>{
    Monument findByName(String name);
    List<Monument> findByLocation(String location);
}




