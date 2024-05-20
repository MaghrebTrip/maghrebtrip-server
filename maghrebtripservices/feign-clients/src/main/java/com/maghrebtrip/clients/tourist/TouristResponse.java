package com.maghrebtrip.clients.tourist;

import lombok.Data;

@Data
public class TouristResponse {
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String nationality;
    private String[] preferences;
}
