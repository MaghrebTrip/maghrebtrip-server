package com.maghrebtrip.tourist;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("api/v1/tourists/")
@CrossOrigin("http://localhost:5173/")
public class TouristController {

    private final TouristService touristService;

    @GetMapping("all")
    public List<Tourist> getAllTourists() {
        return touristService.getAllTourists();
    }
    @GetMapping("tourist/id={id}")
    public Tourist getTouristById(@PathVariable("id") Integer id) {
        return touristService.getTouristById(id);
    }
    @GetMapping("tourist/email={email}")
    public ResponseEntity<Tourist> getTouristByEmail(@PathVariable("email") String email) {
        return ResponseEntity.ok(touristService.getTouristByEmail(email));
    }

    @PostMapping("new")
    public ResponseEntity<Tourist> registerTourist(@RequestBody TouristRegistrationRequest touristRegistrationRequest) {
        return ResponseEntity.ok(touristService.registerTourist(touristRegistrationRequest));
    }

    @PutMapping("update/id={id}")
    public ResponseEntity<Tourist> updateTourist(@PathVariable("id") Integer id, @RequestBody TouristUpdateRequest touristUpdateRequest) {
        return ResponseEntity.ok(touristService.updateTourist(id, touristUpdateRequest));
    }

    @PutMapping("update-photo/id={id}")
    public ResponseEntity<Tourist> updateTouristPhoto(@PathVariable("id") Integer id, @RequestParam("image") MultipartFile image) throws IOException {
        return ResponseEntity.ok(touristService.updateTouristPhoto(id, image));
    }

    @DeleteMapping("delete/id={id}")
    public ResponseEntity<String> deleteTourist(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(touristService.deleteTourist(id));
    }

}
