package com.maghrebtrip.tourist;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.AllArgsConstructor;

import java.util.List;

@Service
@AllArgsConstructor
public class TouristService {

    private final TouristRepository touristRepository;
    private final RestTemplate restTemplate;

    public List<Tourist> getAllTourists() {
        return touristRepository.findAll();
    }

    public String registerTourist(TouristRegistrationRequest request) {
        Tourist tourist = Tourist.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .password(request.password())
                .nationality(request.nationality())
                .preferences(request.preferences())
                .build();
        // TODO: check if email is valid
        // TODO: check if email not taken
        touristRepository.saveAndFlush(tourist);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        String requestBody = "{\"touristId\":\"1\",\"attractionId\":\"1\",\"rating\":\"5\",\"comment\":\"I like it!\"}";
        HttpEntity<String> requestEntity = new HttpEntity<>(requestBody, headers);

        return restTemplate.postForObject(
                "http://FEEDBACK/api/v1/feedbacks/new",
                requestEntity,
                String.class);
    }

    public void updateTourist(Integer id, TouristUpdateRequest request) {
        Tourist tourist = touristRepository.findById(id).get();
        tourist.setFirstName(request.firstName());
        tourist.setLastName(request.lastName());
        tourist.setEmail(request.email());
        tourist.setPassword(request.password());
        tourist.setNationality(request.nationality());
        tourist.setPreferences(request.preferences());
        touristRepository.save(tourist);
    }

    public void deleteTourist(Integer id) {
        touristRepository.deleteById(id);
    }

}
