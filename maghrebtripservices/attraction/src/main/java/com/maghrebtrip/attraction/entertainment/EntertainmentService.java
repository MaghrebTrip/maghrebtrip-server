package com.maghrebtrip.attraction.entertainment;

import com.maghrebtrip.attraction.entertainment.Entertainment;
import com.maghrebtrip.attraction.entertainment.EntertainmentRepository;
import com.maghrebtrip.attraction.entertainment.dto.EntertainmentRegistrationRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EntertainmentService {
    private final EntertainmentRepository entertainmentRepository;

    public List<Entertainment> getAllEntertainments() {
        return entertainmentRepository.findAll();
    }

    public void registerEntertainment(EntertainmentRegistrationRequest request) {
        Entertainment entertainment;
        entertainment = Entertainment.builder()
                .name(request.name())
                .cityId(request.cityId())
                .location(request.location())
                .description(request.description())
                .email(request.email())
                .phone(request.phone())
                .sponsored(request.sponsored())
                .availability(request.availability())
                .build();

        entertainmentRepository.save(entertainment);
    }

    public void updateEntertainment(Integer id, EntertainmentRegistrationRequest request) {
        Entertainment entertainment = entertainmentRepository.findById(id).get();
        entertainment.setName(request.name());
        entertainment.setCityId(request.cityId());
        entertainment.setLocation(request.location());
        entertainment.setDescription(request.description());
        entertainment.setEmail(request.email());
        entertainment.setPhone(request.phone());
        entertainment.setSponsored(request.sponsored());
        entertainment.setAvailability(request.availability());

        entertainmentRepository.save(entertainment);
    }

    public void deleteEntertainment(Integer id) {
        entertainmentRepository.deleteById(id);
    }
}



