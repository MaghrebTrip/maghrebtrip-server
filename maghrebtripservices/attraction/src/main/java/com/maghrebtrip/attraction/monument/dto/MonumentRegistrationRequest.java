package com.maghrebtrip.attraction.monument.dto;

public record MonumentRegistrationRequest(
        String name,
        Integer cityId,
        String location,
        String description,
        String email,
        String phone,
        Integer sponsored,
        Integer rating,
        String history
) {
}
