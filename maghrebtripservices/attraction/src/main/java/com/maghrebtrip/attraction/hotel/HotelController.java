package com.maghrebtrip.attraction.hotel;

import com.maghrebtrip.attraction.hotel.dto.HotelRegistrationRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/api/hotels")
public class HotelController {

    private final HotelService hotelService;

    @GetMapping("/get/all")
    public List<Hotel> getAllHotels() {
        return hotelService.getAllHotels();
    }

    @GetMapping("/get/name={name}")
    public Hotel getHotelByName(@PathVariable("name") String name) {
        return hotelService.getHotelByName(name);
    }


    @GetMapping("/get/location={location}")
    public List<Hotel> getHotelsByLocation (@PathVariable("location") String location) {
        return hotelService.getHotelsByLocation(location);
    }

    @PostMapping("/new")
    public ResponseEntity<String> registerHotel(@RequestBody HotelRegistrationRequest request) {
        hotelService.registerHotel(request);
        return ResponseEntity.ok("Hotel registered successfully");
    }

    @PutMapping("/update/id={id}")
    public void updateHotel (@PathVariable("id") Integer id, @RequestBody HotelRegistrationRequest hotelRegistrationRequest) {
        hotelService.updateHotel(id, hotelRegistrationRequest);
    }

    @DeleteMapping("/delete/id={id}")
    public void deleteHotel(@PathVariable("id") Integer id) {
        hotelService.deleteHotel(id);
    }
}
