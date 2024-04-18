package com.maghrebtrip.attraction.monument;

import com.maghrebtrip.attraction.monument.MonumentBuilder;

public class MonumentBuilder {
    private String name;
    private Integer cityId;
    private String location;
    private String description;
    private String email;
    private String phone;
    private Integer sponsored;
    private Integer rating;
    private String history;

    public MonumentBuilder name(String name) {
        this.name = name;
        return this;
    }

    public MonumentBuilder cityId(Integer cityId) {
        this.cityId = cityId;
        return this;
    }

    public MonumentBuilder location(String location) {
        this.location = location;
        return this;
    }

    public MonumentBuilder description(String description) {
        this.description = description;
        return this;
    }

    public MonumentBuilder email(String email) {
        this.email = email;
        return this;
    }

    public MonumentBuilder phone(String phone) {
        this.phone = phone;
        return this;
    }

    public MonumentBuilder sponsored(Integer sponsored) {
        this.sponsored = sponsored;
        return this;
    }

    public MonumentBuilder rating(Integer rating) {
        this.rating = rating;
        return this;
    }

    public MonumentBuilder history(String history){
        this.history=history;
        return this;
    }

    public Monument build(){
        Monument monument = new Monument();
        monument.setName(name);
        monument.setCityId(cityId);
        monument.setLocation(location);
        monument.setDescription(description);
        monument.setEmail(email);
        monument.setPhone(phone);
        monument.setSponsored(sponsored);
        monument.setRating(rating);
        monument.setHistory(history);

        return monument;
    }
}
