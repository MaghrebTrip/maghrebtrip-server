package com.maghrebtrip.attraction.entertainment.dto;

public record EntertainmentRegistrationRequest(
    String name,
    Integer cityId,
    String location,
    String description,
    String email,
    String phone,
    Integer sponsored,
    Integer rating,
    Boolean availability
){
}
