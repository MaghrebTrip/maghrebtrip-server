package com.maghrebtrip.clients.tourist.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetTouristResponse {
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String nationality;
    private String[] preferences;
}
