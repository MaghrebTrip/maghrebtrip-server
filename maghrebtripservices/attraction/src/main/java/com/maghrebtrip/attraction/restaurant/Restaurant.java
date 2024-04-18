package com.maghrebtrip.attraction.restaurant;


import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.maghrebtrip.attraction.Attraction;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Restaurant extends Attraction {

    private String email;
    private String phone;
    private String cuisineType;
    private String affordability;

    public static RestaurantBuilder builder() {
        return new RestaurantBuilder();
    }

}
