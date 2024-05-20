package com.maghrebtrip.attraction.hotel;

import com.maghrebtrip.attraction.hotel.dto.HotelRegistrationRequest;
import com.opencsv.CSVReader;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.List;

@Service
@AllArgsConstructor
public class HotelService {

    private final HotelRepository hotelRepository;

    public List<Hotel> getAllHotels() {return hotelRepository.findAll();}
    public List<Hotel> getHotelByCityId(Integer cityId) {
        return hotelRepository.findByCityId(cityId);
    }
    public Hotel getHotelByName(String name) {return (Hotel) hotelRepository.findByName(name);}
    public List<Hotel> getHotelsByLocation(String location) {return hotelRepository.findByLocation(location);}

    public void registerHotel(HotelRegistrationRequest request) {
        Hotel hotel;
        hotel = Hotel.builder()
                .name(request.name())
                .image(request.image())
                .type(request.type())
                .cityId(request.cityId())
                .location(request.location())
                .description(request.description())
                .sponsored(request.sponsored())
                .rating(request.rating())
                .schedules(request.schedules())
                .amenities(request.amenities())
                .roomTypes(request.roomTypes())
                .build();

        hotelRepository.save(hotel);
    }

    public void updateHotel (Integer id, HotelRegistrationRequest request) {
        Hotel hotel = hotelRepository.findById(id).get();
        hotel.setName(request.name());
        hotel.setImage(request.image());
        hotel.setType(request.type());
        hotel.setCityId(request.cityId());
        hotel.setLocation(request.location());
        hotel.setDescription(request.description());
        hotel.setSponsored(request.sponsored());
        hotel.setSchedules(request.schedules());
        hotel.setRating(request.rating());
        hotel.setAmenities(request.amenities());
        hotel.setRoomTypes(request.roomTypes());

        hotelRepository.save(hotel);
    }

    public void deleteHotel(Integer id) {
        hotelRepository.deleteById(id);
    }

    public byte[] getImage(String url) throws IOException {
        URL imageUrl = new URL(url);
        return imageUrl.openStream().readAllBytes();
    }

    public void loadHotelsDataFromCSV() {
        // columns: city_id,name,image,type,description,location,rating,schedule,sponsored,room_types,amenities
        String path = "maghrebtripservices/attraction/src/main/resources/hotels.csv";
        try (CSVReader reader = new CSVReader(new FileReader(path))) {
            String[] lineInArray;
            reader.readNext();
            while ((lineInArray = reader.readNext()) != null) {
                Hotel hotel = Hotel.builder()
                        .cityId(Integer.parseInt(lineInArray[0]))
                        .name(lineInArray[1])
                        .image(getImage(lineInArray[2]))
                        .type(lineInArray[3])
                        .description(lineInArray[4])
                        .location(lineInArray[5])
                        .rating(Float.parseFloat((lineInArray[6])))
                        .schedules(null) //TODO: add schedule
                        .sponsored(Integer.parseInt(lineInArray[8]))
                        .roomTypes(lineInArray[9])
                        .amenities(null) //TODO: add amenities
                        .build();
                hotelRepository.save(hotel);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
