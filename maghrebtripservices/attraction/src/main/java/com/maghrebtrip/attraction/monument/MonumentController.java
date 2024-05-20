package com.maghrebtrip.attraction.monument;

import com.maghrebtrip.attraction.monument.dto.MonumentRegistrationRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/attractions/monuments/")
public class MonumentController {
    private final MonumentService monumentService;

    @GetMapping("all")
    public List<Monument> getAllMonuments() {
        return monumentService.getAllMonuments();
    }

    @GetMapping("city={cityId}")
    public List<Monument> getMonumentByCityId(@PathVariable("cityId") Integer cityId) {return monumentService.getMonumentByCityId(cityId);}

    @GetMapping("name={name}")
    public Monument getMonumentByName(@PathVariable("name") String name) {
        return monumentService.getMonumentByName(name);
    }

    @GetMapping("location={location}")
    public List<Monument> getMonumentsByLocation (@PathVariable("location") String location) {
        return monumentService.getMonumentsByLocation(location);
    }

    @PostMapping("new")
    public ResponseEntity<String> registerMonument(@RequestBody MonumentRegistrationRequest request) {
        monumentService.registerMonument(request);
        return ResponseEntity.ok("Monument registered successfully");
    }

    @PutMapping("update/id={id}")
    public void updateMonument (@PathVariable("id") Integer id, @RequestBody MonumentRegistrationRequest monumentRegistrationRequest) {
        monumentService.updateMonument(id, monumentRegistrationRequest);
    }

    @DeleteMapping("delete/id={id}")
    public void deleteMonument(@PathVariable("id") Integer id) {
        monumentService.deleteMonument(id);
    }

}

