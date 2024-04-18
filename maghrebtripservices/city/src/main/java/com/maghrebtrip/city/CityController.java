package com.maghrebtrip.city;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("api/v1/cities")
@AllArgsConstructor
public class CityController {

    private final CityRepository cityRepository;
    private final CityService cityService;

    @GetMapping("all")
    public List<City> getAllCities() {return cityService.getAllCities();}

    @GetMapping("city/{id}")
    public City getCity(@PathVariable("id") Integer id) {return cityService.getCity(id);}

    @PostMapping("new")
    public ResponseEntity<String> registerCity(@RequestBody RegisterCityRequest registerCityRequest) {
        String response;
        try {
            response = cityService.registerCity(registerCityRequest);
        } catch (IOException e) {
            return ResponseEntity.badRequest().body("Error registering city");
        }
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteCity(@PathVariable("id") Integer id) {
        cityService.deleteCity(id);
        return ResponseEntity.ok("City deleted successfully!");
    }

    @PutMapping("update/{id}")
    public ResponseEntity<String> updateCity(@PathVariable("id") Integer id, @RequestBody UpdateCityRequest updateCityRequest) {
        try {
            cityService.updateCity(id, updateCityRequest);
        } catch (IOException e) {
            return ResponseEntity.badRequest().body("Error updating city");
        }
        return ResponseEntity.ok("City updated successfully!");
    }
}
