package com.maghrebtrip.attraction.hotel.dto;

public record HotelRegistrationRequest(
        String name,
        Integer cityId,
        String location,
        String description,
        String email,
        String phone,
        Integer sponsored,
        Integer rating,
        String[] amenities
) {
}
