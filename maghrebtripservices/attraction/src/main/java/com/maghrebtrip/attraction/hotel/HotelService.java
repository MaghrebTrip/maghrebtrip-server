package com.maghrebtrip.attraction.hotel;

import com.maghrebtrip.attraction.hotel.dto.HotelRegistrationRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class HotelService {

    private final HotelRepository hotelRepository;

    public List<Hotel> getAllHotels() {return hotelRepository.findAll();}
    public Hotel getHotelByName(String name) {return (Hotel) hotelRepository.findByName(name);}
    public List<Hotel> getHotelsByLocation(String location) {return hotelRepository.findByLocation(location);}

    public void registerHotel(HotelRegistrationRequest request) {
        Hotel hotel;
        hotel = Hotel.builder()
                .name(request.name())
                .cityId(request.cityId())
                .location(request.location())
                .description(request.description())
                .email(request.email())
                .phone(request.phone())
                .sponsored(request.sponsored())
                .rating(request.rating())
                .amenities(request.amenities())
                .build();

        hotelRepository.save(hotel);
    }

    public void updateHotel (Integer id, HotelRegistrationRequest request) {
        Hotel hotel = hotelRepository.findById(id).get();
        hotel.setName(request.name());
        hotel.setCityId(request.cityId());
        hotel.setLocation(request.location());
        hotel.setDescription(request.description());
        hotel.setEmail(request.email());
        hotel.setPhone(request.phone());
        hotel.setSponsored(request.sponsored());
        hotel.setRating(request.rating());
        hotel.setRating(request.rating());

        hotelRepository.save(hotel);
    }

    public void deleteHotel(Integer id) {
        hotelRepository.deleteById(id);
    }

}
