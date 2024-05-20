package com.maghrebtrip.attraction.monument;

import com.maghrebtrip.attraction.monument.dto.MonumentRegistrationRequest;
import com.opencsv.CSVReader;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.List;

@Service
@AllArgsConstructor
public class MonumentService {

    private final MonumentRepository monumentRepository;

    public List<Monument> getAllMonuments() {return monumentRepository.findAll();}
    public List<Monument> getMonumentByCityId(Integer cityId) {
        return monumentRepository.findByCityId(cityId);
    }
    public Monument getMonumentByName(String name) {return (Monument) monumentRepository.findByName(name);}
    public List<Monument> getMonumentsByLocation(String location) {return monumentRepository.findByLocation(location);}

    public void registerMonument(MonumentRegistrationRequest request) {
        Monument monument;
        monument = Monument.builder()
                .name(request.name())
                .image(request.image())
                .type(request.type())
                .cityId(request.cityId())
                .location(request.location())
                .description(request.description())
                .sponsored(request.sponsored())
                .rating(request.rating())
                .schedules(request.schedules())
                .build();

        monumentRepository.save(monument);
    }

    public void updateMonument (Integer id, MonumentRegistrationRequest request) {
        Monument monument = monumentRepository.findById(id).get();
        monument.setName(request.name());
        monument.setImage(request.image());
        monument.setType(request.type());
        monument.setCityId(request.cityId());
        monument.setLocation(request.location());
        monument.setDescription(request.description());
        monument.setSponsored(request.sponsored());
        monument.setRating(request.rating());
        monument.setSchedules(request.schedules());

        monumentRepository.save(monument);
    }

    public void deleteMonument(Integer id) {
        monumentRepository.deleteById(id);
    }

    public byte[] getImage(String url) throws IOException {
        URL imageUrl = new URL(url);
        return imageUrl.openStream().readAllBytes();
    }

    public void loadMonumentsDataFromCSV() {
        // columns: city_id,name,image,type,description,location,rating,schedule,sponsored
        String path = "maghrebtripservices/attraction/src/main/resources/monuments.csv";
        try (CSVReader reader = new CSVReader(new FileReader(path))) {
            String[] lineInArray;
            reader.readNext();
            while ((lineInArray = reader.readNext()) != null) {
                Monument monument = Monument.builder() //TODO: add all columns
                        .cityId(Integer.parseInt(lineInArray[0]))
                        .name(lineInArray[1])
                        .image(getImage(lineInArray[2]))
                        .type(lineInArray[3])
                        .description(lineInArray[4])
                        .location(lineInArray[5])
                        .rating(Float.parseFloat((lineInArray[6])))
                        .schedules(null) //TODO: add schedule
                        .sponsored(Integer.parseInt(lineInArray[8]))
                        .build();
                monumentRepository.save(monument);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}

