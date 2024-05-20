package com.maghrebtrip.attraction.hotel.dto;

import com.maghrebtrip.attraction.Schedule;

import java.util.List;

public record HotelRegistrationRequest(
        String name,
        byte[] image,
        String type,
        Integer cityId,
        String location,
        String description,
        Integer sponsored,
        Float rating,
        List<Schedule> schedules,
        String roomTypes,
        String[] amenities
) {
}
