package com.maghrebtrip.attraction.entertainment;

import com.maghrebtrip.attraction.entertainment.Entertainment;
import com.maghrebtrip.attraction.restaurant.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EntertainmentRepository extends JpaRepository<Entertainment, Integer> {

}
