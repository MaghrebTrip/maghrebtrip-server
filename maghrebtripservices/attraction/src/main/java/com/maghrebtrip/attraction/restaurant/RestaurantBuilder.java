package com.maghrebtrip.attraction.restaurant;

import com.maghrebtrip.attraction.Schedule;

import java.util.List;

public class RestaurantBuilder {

    private String name;
    private byte[] image;
    private String type;
    private Integer cityId;
    private String location;
    private String description;
    private Integer sponsored;
    private String cuisineType;
    private String affordability;
    private Float rating;
    private List<Schedule> schedules;

    public RestaurantBuilder name(String name) {
        this.name = name;
        return this;
    }

    public RestaurantBuilder image(byte[] image) {
        this.image = image;
        return this;
    }

    public RestaurantBuilder type(String type) {
        this.type = type;
        return this;
    }

    public RestaurantBuilder cityId(Integer cityId) {
       this.cityId = cityId;
       return this;
    }

    public RestaurantBuilder location(String location) {
        this.location = location;
        return this;
    }

    public RestaurantBuilder description(String description) {
        this.description = description;
        return this;
    }

    public RestaurantBuilder sponsored(Integer sponsored) {
        this.sponsored = sponsored;
        return this;
    }

    public RestaurantBuilder cuisineType(String cuisineType) {
        this.cuisineType = cuisineType;
        return this;
    }

    public RestaurantBuilder affordability(String affordability) {
        this.affordability = affordability;
        return this;
    }

    public RestaurantBuilder rating(Float rating) {
        this.rating = rating;
        return this;
    }

    public RestaurantBuilder schedules(List<Schedule> schedules) {
        this.schedules = schedules;
        return this;
    }

    public Restaurant build() {
        Restaurant restaurant = new Restaurant();
        restaurant.setName(name);
        restaurant.setImage(image);
        restaurant.setType(type);
        restaurant.setCityId(cityId);
        restaurant.setLocation(location);
        restaurant.setDescription(description);
        restaurant.setSponsored(sponsored);
        restaurant.setCuisineType(cuisineType);
        restaurant.setAffordability(affordability);
        restaurant.setRating(rating);
        restaurant.setSchedules(schedules);

        return restaurant;
    }
}
