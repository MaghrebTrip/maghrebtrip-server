package com.maghrebtrip.attraction.monument;

import com.maghrebtrip.attraction.Schedule;
import com.maghrebtrip.attraction.monument.MonumentBuilder;

import java.util.List;

public class MonumentBuilder {
    private String name;
    private byte[] image;
    private String type;
    private Integer cityId;
    private String location;
    private String description;
    private Integer sponsored;
    private Float rating;
    private List<Schedule> schedules;

    public MonumentBuilder name(String name) {
        this.name = name;
        return this;
    }

    public MonumentBuilder image(byte[] image) {
        this.image = image;
        return this;
    }

    public MonumentBuilder type(String type) {
        this.type = type;
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

    public MonumentBuilder sponsored(Integer sponsored) {
        this.sponsored = sponsored;
        return this;
    }

    public MonumentBuilder rating(Float rating) {
        this.rating = rating;
        return this;
    }

    public MonumentBuilder schedules(List<Schedule> schedules) {
        this.schedules = schedules;
        return this;
    }

    public Monument build(){
        Monument monument = new Monument();
        monument.setName(name);
        monument.setImage(image);
        monument.setType(type);
        monument.setCityId(cityId);
        monument.setLocation(location);
        monument.setDescription(description);
        monument.setSponsored(sponsored);
        monument.setRating(rating);
        monument.setSchedules(schedules);

        return monument;
    }
}
