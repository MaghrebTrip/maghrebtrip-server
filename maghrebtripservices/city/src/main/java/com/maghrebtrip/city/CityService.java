package com.maghrebtrip.city;

import com.opencsv.CSVReader;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

@Service
@AllArgsConstructor
public class CityService {
    private final CityRepository cityRepository;

    public List<City> getAllCities() {
        return cityRepository.findAll();
    }

    public City getCity(Integer id) {
        return cityRepository.findById(id).get();
    }

    public String registerCity(RegisterCityRequest request) throws IOException {
        City city = City.builder()
                .name(request.name())
                .image(request.image().getBytes())
                .about(request.about())
                .rating(request.rating())
                .build();
        cityRepository.saveAndFlush(city);
        String response = "City registered successfully!";
        return response;
    }

    public void loadCityDataFromCSV() {
        String path = "maghrebtripservices/city/src/main/resources/cities.csv";
        try (CSVReader reader = new CSVReader(new FileReader(path))) {
            String[] lineInArray;
            reader.readNext();
            while ((lineInArray = reader.readNext()) != null) {
                City city = City.builder()
                        .name(lineInArray[0])
                        .image(lineInArray[4].getBytes())
                        .about(lineInArray[3])
                        .rating((float) (Math.random() * 5))
                        .build();
                cityRepository.save(city);
            }
        }
         catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateCity(Integer id, UpdateCityRequest request) throws IOException {
        City city = cityRepository.findById(id).get();
        city.setName(request.name());
        city.setImage(request.image().getBytes());
        city.setAbout(request.about());
        city.setRating(request.rating());
        cityRepository.save(city);
    }

    public void deleteCity(Integer id) {
        cityRepository.deleteById(id);
    }
}
