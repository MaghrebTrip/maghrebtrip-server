package com.maghrebtrip.tourist;

public record TouristUpdateRequest(
        String firstName,
        String lastName,
        String email,
        String password,
        String nationality,
        String[] preferences
) {
}
