package com.maghrebtrip.city;

import org.springframework.web.multipart.MultipartFile;

public record UpdateCityRequest(
        String name,
        MultipartFile image,
        String about,
        float rating
) {
}
