package com.maghrebtrip.trip;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Trip {

    @GeneratedValue(strategy = GenerationType.IDENTITY) // Specifies auto-generation for the ID
    @Id
    private Integer id;
    private Integer touristId;
    private Integer cityId;
    //@JsonFormat(pattern = "yyyy-MM-dd")
    private Date checkIn;
    //@JsonFormat(pattern = "yyyy-MM-dd")
    private Date checkOut;
    private int adults;
    private int infants;
    private int pets;
    private int rooms;

}
