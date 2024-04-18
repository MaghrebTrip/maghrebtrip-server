package com.maghrebtrip.attraction.entertainment;

import com.maghrebtrip.attraction.entertainment.Entertainment;

public class EntertainmentBuilder {

    private String name;
    private Integer cityId;
    private String location;
    private String description;
    private String email;
    private String phone;
    private Integer sponsored;
    private Boolean availability;

    public com.maghrebtrip.attraction.entertainment.EntertainmentBuilder name(String name) {
        this.name = name;
        return this;
    }

    public EntertainmentBuilder cityId(Integer cityId) {
       this.cityId = cityId;
     return this;
    }

    public com.maghrebtrip.attraction.entertainment.EntertainmentBuilder location(String location) {
        this.location = location;
        return this;
    }

    public com.maghrebtrip.attraction.entertainment.EntertainmentBuilder description(String description) {
        this.description = description;
        return this;
    }

    public com.maghrebtrip.attraction.entertainment.EntertainmentBuilder email(String email) {
        this.email = email;
        return this;
    }

    public com.maghrebtrip.attraction.entertainment.EntertainmentBuilder phone(String phone) {
        this.phone = phone;
        return this;
    }

    public com.maghrebtrip.attraction.entertainment.EntertainmentBuilder sponsored(Integer sponsored) {
        this.sponsored = sponsored;
        return this;
    }

    public com.maghrebtrip.attraction.entertainment.EntertainmentBuilder availability(Boolean availability) {
        this.availability = availability;
        return this;
    }

    public Entertainment build() {
        Entertainment entertainment = new Entertainment();
        entertainment.setName(name);
        entertainment.setCityId(cityId);
        entertainment.setLocation(location);
        entertainment.setDescription(description);
        entertainment.setEmail(email);
        entertainment.setPhone(phone);
        entertainment.setSponsored(sponsored);
        entertainment.setAvailability(availability);

        // Perform any additional operations here if needed

        return entertainment;
    }

}

