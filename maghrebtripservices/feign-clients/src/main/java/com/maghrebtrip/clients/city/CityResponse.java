package com.maghrebtrip.clients.city;


import lombok.Data;

@Data
public class CityResponse {
    private Integer id;
    private String name;
    private byte[] image;
    private String about;
    private float rating;
}
