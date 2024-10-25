package com.maghrebtrip.tourist.dto;

public record TouristRegistrationRequest(
        Integer id,
        String firstName,
        String lastName,
        String email,
        String password,
        String nationality,
        String[] preferences
) {
}