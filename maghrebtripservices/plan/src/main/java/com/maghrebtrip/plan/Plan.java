package com.maghrebtrip.plan;

import com.maghrebtrip.clients.attraction.AttractionResponse;
import jakarta.persistence.*;
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
    @ElementCollection
    private List<AttractionResponse> attractions;
}
