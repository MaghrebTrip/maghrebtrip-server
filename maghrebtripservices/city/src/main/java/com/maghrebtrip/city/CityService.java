package com.maghrebtrip.city;

import com.opencsv.CSVReader;
import lombok.AllArgsConstructor;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
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

    public City registerCity(RegisterCityRequest request) throws IOException {
        City city = City.builder()
                .name(request.name())
                .image(request.image().getBytes())
                .about(request.about())
                .rating(request.rating())
                .build();
        return cityRepository.saveAndFlush(city);
    }

    public byte[] getImage(String url) throws IOException {
        URL imageUrl = new URL(url);
        return imageUrl.openStream().readAllBytes();
    }

    public void loadCityDataFromCSV() {
        ClassPathResource resource = new ClassPathResource("cities.csv");
        try (CSVReader reader = new CSVReader(new InputStreamReader(resource.getInputStream()))) {
            String[] lineInArray;
            reader.readNext();
            while ((lineInArray = reader.readNext()) != null) {
                City city = City.builder()
                        .name(lineInArray[0])
                        .about(lineInArray[1])
                        .image(getImage(lineInArray[2]))
                        .rating(Float.parseFloat((lineInArray[3])))
                        .build();
                cityRepository.save(city);
            }
        }
         catch (Exception e) {
            e.printStackTrace();
        }
    }

    public City updateCity(Integer id, UpdateCityRequest request) throws IOException {
        City city = cityRepository.findById(id).get();
        city.setName(request.name());
        city.setImage(request.image().getBytes());
        city.setAbout(request.about());
        city.setRating(request.rating());
        return cityRepository.save(city);
    }

    public void deleteCity(Integer id) {
        cityRepository.deleteById(id);
    }
}
