package com.maghrebtrip.attraction.restaurant;

public class RestaurantBuilder {

  private String name;
    private Integer cityId;
    private String location;
    private String description;
    private String email;
    private String phone;
    private Integer sponsored;
    private String cuisineType;
    private String affordability;

    public RestaurantBuilder name(String name) {
        this.name = name;
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

    public RestaurantBuilder email(String email) {
        this.email = email;
        return this;
    }

    public RestaurantBuilder phone(String phone) {
        this.phone = phone;
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

    public Restaurant build() {
        Restaurant restaurant = new Restaurant();
        restaurant.setName(name);
        restaurant.setCityId(cityId);
        restaurant.setLocation(location);
        restaurant.setDescription(description);
        restaurant.setEmail(email);
        restaurant.setPhone(phone);
        restaurant.setSponsored(sponsored);
        restaurant.setCuisineType(cuisineType);
        restaurant.setAffordability(affordability);

        // Perform any additional operations here if needed

        return restaurant;
    }
}
