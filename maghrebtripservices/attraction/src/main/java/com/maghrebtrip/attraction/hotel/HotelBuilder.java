package com.maghrebtrip.attraction.hotel;


import com.maghrebtrip.attraction.Schedule;

import java.util.List;

public class HotelBuilder {


    private String name;
    private byte[] image;
    private String type;
    private Integer cityId;
    private String location;
    private String description;
    private Integer sponsored;
    private Float rating;
    private List<Schedule> schedules;
    private String[] amenities;
    private String roomTypes;

    public HotelBuilder name(String name) {
        this.name = name;
        return this;
    }

    public HotelBuilder image(byte[] image) {
        this.image = image;
        return this;
    }

    public HotelBuilder type(String type) {
        this.type = type;
        return this;
    }

    public HotelBuilder cityId(Integer cityId) {
        this.cityId = cityId;
        return this;
    }

    public HotelBuilder location(String location) {
        this.location = location;
        return this;
    }

    public HotelBuilder description(String description) {
        this.description = description;
        return this;
    }

    public HotelBuilder sponsored(Integer sponsored) {
        this.sponsored = sponsored;
        return this;
    }

    public HotelBuilder rating(Float rating) {
        this.rating = rating;
        return this;
    }

    public HotelBuilder schedules(List<Schedule> schedules) {
        this.schedules = schedules;
        return this;
    }

    public HotelBuilder amenities(String[] amenities) {
        this.amenities = amenities;
        return this;
    }

    public HotelBuilder roomTypes(String roomTypes) {
        this.roomTypes = roomTypes;
        return this;
    }

    public Hotel build() {
        Hotel hotel = new Hotel();
        hotel.setName(name);
        hotel.setImage(image);
        hotel.setType(type);
        hotel.setCityId(cityId);
        hotel.setLocation(location);
        hotel.setDescription(description);
        hotel.setSponsored(sponsored);
        hotel.setRating(rating);
        hotel.setSchedules(schedules);
        hotel.setAmenities(amenities);
        hotel.setRoomTypes(roomTypes);

        return hotel;
    }
}