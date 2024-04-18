package com.maghrebtrip.attraction.entertainment;

import com.maghrebtrip.attraction.Attraction;
import com.maghrebtrip.attraction.entertainment.EntertainmentBuilder;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Entertainment extends Attraction{

    private String email;
    private String phone;
    private Boolean availability;

    public static EntertainmentBuilder builder() {
        return new EntertainmentBuilder();
    }

}

