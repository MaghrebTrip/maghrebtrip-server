package com.maghrebtrip.attraction.hotel;



public class HotelBuilder {


    private String name;
    private Integer cityId;
    private String location;
    private String description;
    private String email;
    private String phone;
    private Integer sponsored;
    private Integer rating;
    private String[] amenities;

    public HotelBuilder name(String name) {
        this.name = name;
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

    public HotelBuilder email(String email) {
        this.email = email;
        return this;
    }

    public HotelBuilder phone(String phone) {
        this.phone = phone;
        return this;
    }

    public HotelBuilder sponsored(Integer sponsored) {
        this.sponsored = sponsored;
        return this;
    }



    // Add similar methods for other fields

    public HotelBuilder rating(Integer rating) {
        this.rating = rating;
        return this;
    }

    public HotelBuilder amenities(String[] amenities) {
        this.amenities = amenities;
        return this;
    }

    public Hotel build() {
        Hotel hotel = new Hotel();
        hotel.setName(name);
        hotel.setCityId(cityId);
        hotel.setLocation(location);
        hotel.setDescription(description);
        hotel.setEmail(email);
        hotel.setPhone(phone);
        hotel.setSponsored(sponsored);
        hotel.setRating(rating);
        hotel.setAmenities(amenities);

        // Perform any additional operations here if needed

        return hotel;
    }
}