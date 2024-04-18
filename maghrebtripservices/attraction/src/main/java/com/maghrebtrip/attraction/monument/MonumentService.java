package com.maghrebtrip.attraction.monument;

import com.maghrebtrip.attraction.monument.Monument;
import com.maghrebtrip.attraction.monument.MonumentRepository;
import com.maghrebtrip.attraction.monument.dto.MonumentRegistrationRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MonumentService {

    private final MonumentRepository monumentRepository;

    public List<Monument> getAllMonuments() {return monumentRepository.findAll();}
    public Monument getMonumentByName(String name) {return (Monument) monumentRepository.findByName(name);}
    public List<Monument> getMonumentsByLocation(String location) {return monumentRepository.findByLocation(location);}

    public void registerMonument(MonumentRegistrationRequest request) {
        Monument monument;
        monument = Monument.builder()
                .name(request.name())
                .cityId(request.cityId())
                .location(request.location())
                .description(request.description())
                .email(request.email())
                .phone(request.phone())
                .sponsored(request.sponsored())
                .rating(request.rating())
                .history(request.history())
                .build();

        monumentRepository.save(monument);
    }

    public void updateMonument (Integer id, MonumentRegistrationRequest request) {
        Monument monument = monumentRepository.findById(id).get();
        monument.setName(request.name());
        monument.setCityId(request.cityId());
        monument.setLocation(request.location());
        monument.setDescription(request.description());
        monument.setEmail(request.email());
        monument.setPhone(request.phone());
        monument.setSponsored(request.sponsored());
        monument.setRating(request.rating());
        monument.setHistory(request.history());

        monumentRepository.save(monument);
    }

    public void deleteMonument(Integer id) {
        monumentRepository.deleteById(id);
    }

}

