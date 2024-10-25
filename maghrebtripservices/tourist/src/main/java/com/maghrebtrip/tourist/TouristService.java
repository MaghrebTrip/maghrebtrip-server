package com.maghrebtrip.tourist;

import com.maghrebtrip.tourist.dto.TouristRegistrationRequest;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

import java.util.List;

@Service
@AllArgsConstructor
public class TouristService {

    private final TouristRepository touristRepository;

    public List<Tourist> getAllTourists() {
        return touristRepository.findAll();
    }

    public Tourist getTouristById(Integer id) {
        if (touristRepository.findById(id).isPresent()) {
            return touristRepository.findById(id).get();
        } else {
            return null;
        }
    }

    public Tourist getTouristByEmail(String email) {
        if (touristRepository.findByEmail(email).isPresent()) {
            return touristRepository.findByEmail(email).get();
        } else {
            return null;
        }
    }

    public Tourist registerTourist(TouristRegistrationRequest request) {
        Tourist tourist = Tourist.builder()
                .id(request.id())
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .password(request.password())
                .nationality(request.nationality())
                .preferences(request.preferences())
                .build();
        // TODO: check if email is valid
        // TODO: check if email not taken

        return touristRepository.save(tourist);
    }

    public Tourist updateTourist(Integer id, TouristUpdateRequest request) {
        Tourist tourist = touristRepository.findById(id).get();
        tourist.setFirstName(request.firstName());
        tourist.setLastName(request.lastName());
        tourist.setEmail(request.email());
        tourist.setPassword(request.password());
        tourist.setNationality(request.nationality());
        tourist.setPreferences(request.preferences());
        return touristRepository.save(tourist);
    }

    public String deleteTourist(Integer id) {
        if (touristRepository.findById(id).isPresent()) {
            touristRepository.deleteById(id);
            return "Tourist deleted successfully";
        } else {
            return "Tourist no found!";
        }
    }
}
