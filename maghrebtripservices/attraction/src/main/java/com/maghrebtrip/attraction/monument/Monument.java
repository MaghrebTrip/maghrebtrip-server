package com.maghrebtrip.attraction.monument;

import com.maghrebtrip.attraction.Attraction;
import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class Monument extends Attraction{
    public static MonumentBuilder builder() {
        return new MonumentBuilder();
    }
}

