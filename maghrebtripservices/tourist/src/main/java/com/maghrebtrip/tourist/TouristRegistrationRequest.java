package com.maghrebtrip.tourist;

import org.springframework.web.multipart.MultipartFile;

public record TouristRegistrationRequest(
        String firstName,
        String lastName,
        String email,
        String password,
        String nationality,
        String[] preferences
) {
}