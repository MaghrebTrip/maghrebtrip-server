package com.maghrebtrip.attraction.restaurant.dto;

public record RestaurantRegisterationRequest (
        String name,
        Integer cityId,
        String location,
        String description,
        String email,
        String phone,
        Integer sponsored,
        String cuisineType,
        String affordability
) {

}
