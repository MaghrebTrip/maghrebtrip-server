package com.maghrebtrip.attraction.restaurant.dto;

import com.maghrebtrip.attraction.Schedule;

import java.util.List;

public record RestaurantRegisterationRequest (
        String name,
        byte[] image,
        String type,
        Integer cityId,
        String location,
        String description,
        Integer sponsored,
        String cuisineType,
        String affordability,
        Float rating,
        List<Schedule> schedules
) {

}
