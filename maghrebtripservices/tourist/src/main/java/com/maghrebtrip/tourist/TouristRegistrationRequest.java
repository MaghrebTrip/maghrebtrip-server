package com.maghrebtrip.tourist;

public record TouristRegistrationRequest(
        String firstName,
        String lastName,
        String email,
        String password,
        String nationality,
        String[] preferences
) {
}