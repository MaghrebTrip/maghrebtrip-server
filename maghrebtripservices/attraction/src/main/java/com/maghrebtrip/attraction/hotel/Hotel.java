package com.maghrebtrip.attraction.hotel;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.maghrebtrip.attraction.Attraction;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Hotel extends Attraction {

    private String[] amenities;
    private String roomTypes;

    public static HotelBuilder builder() {
        return new HotelBuilder();
    }


}
