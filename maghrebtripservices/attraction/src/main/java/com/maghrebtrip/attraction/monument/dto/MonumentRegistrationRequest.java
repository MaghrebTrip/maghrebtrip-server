package com.maghrebtrip.attraction.monument.dto;

import com.maghrebtrip.attraction.Schedule;

import java.util.List;

public record MonumentRegistrationRequest(
        String name,
        byte[] image,
        String type,
        Integer cityId,
        String location,
        String description,
        Integer sponsored,
        Float rating,
        List<Schedule> schedules
) {
}
