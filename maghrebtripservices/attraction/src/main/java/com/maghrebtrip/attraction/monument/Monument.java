package com.maghrebtrip.attraction.monument;

import com.maghrebtrip.attraction.Attraction;
import com.maghrebtrip.attraction.monument.MonumentBuilder;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Monument extends Attraction{
    private String email;
    private String phone;
    private String history;

    public static MonumentBuilder builder() {
        return new MonumentBuilder();
    }
}

