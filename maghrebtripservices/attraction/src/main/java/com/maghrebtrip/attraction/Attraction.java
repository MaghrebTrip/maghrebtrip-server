package com.maghrebtrip.attraction;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public abstract class Attraction {
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Specifies auto-generation for the ID
    @Id
    private Integer id;
    private Integer cityId;
    private String name;
    private byte[] image;
    private String type;
    private String description;
    @ElementCollection
    private List<Schedule> schedules;
    private String location;
    private float rating;
    private int sponsored;
    //0 not sponsored
    //1 basic plan
    //2 advanced plan
    //3 VIP plan
}
