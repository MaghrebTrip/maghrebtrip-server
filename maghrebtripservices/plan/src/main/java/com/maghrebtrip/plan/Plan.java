package com.maghrebtrip.plan;

import com.maghrebtrip.attraction.Attraction;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Plan {

    @GeneratedValue(strategy = GenerationType.IDENTITY) // Specifies auto-generation for the ID
    @Id
    private Integer id;
    private Integer cityId;
    private List<Attraction> attractions;
}
