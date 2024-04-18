package com.maghrebtrip.city;

import org.springframework.web.multipart.MultipartFile;

public record RegisterCityRequest(
        String name,
        MultipartFile image,
        String about,
        float rating
) {
}
