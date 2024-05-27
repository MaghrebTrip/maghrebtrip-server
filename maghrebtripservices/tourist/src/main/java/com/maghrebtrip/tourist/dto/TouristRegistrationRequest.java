package com.maghrebtrip.tourist.dto;

public record TouristRegistrationRequest(
        String firstName,
        String lastName,
        String email,
        String password,
        String nationality,
        String[] preferences
) {
}