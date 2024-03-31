package com.maghrebtrip.tourist;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("api/v1/tourists/")
public class TouristController {

    private final TouristService touristService;

    @GetMapping("all")
    public List<Tourist> getAllTourists() {
        return touristService.getAllTourists();
    }

    @PostMapping("new")
    public ResponseEntity<String> registerTourist(@RequestBody TouristRegistrationRequest touristRegistrationRequest) {
        String response = touristService.registerTourist(touristRegistrationRequest);
        return ResponseEntity.ok("Tourist registred | " + response);
    }

    @PutMapping("update/id={id}")
    public void updateTourist(@PathVariable("id") Integer id, @RequestBody TouristUpdateRequest touristUpdateRequest) {
        touristService.updateTourist(id, touristUpdateRequest);
    }

    @DeleteMapping("delete/id={id}")
    public void deleteTourist(@PathVariable("id") Integer id) {
        touristService.deleteTourist(id);
    }

}
