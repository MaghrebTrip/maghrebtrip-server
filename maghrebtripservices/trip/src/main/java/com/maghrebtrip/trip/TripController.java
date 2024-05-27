package com.maghrebtrip.trip;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/trips")
@AllArgsConstructor
@CrossOrigin("http://localhost:5173/")
public class TripController {

    private final TripRepository tripRepository;
    private final TripService tripService;

    @GetMapping("all")
    public List<Trip> getAllTrips() {
        return tripService.getAllTrips();
    }

    @PostMapping("new")
    public ResponseEntity<String> registerTrip(@RequestBody RegisterTripRequest registerTripRequest) {
        String response = tripService.registerTrip(registerTripRequest);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteCity(@PathVariable("id") Integer id) {
        tripService.deleteTrip(id);
        return ResponseEntity.ok("Trip deleted successfully!");
    }

    @PutMapping("update/{id}")
    public ResponseEntity<String> updateTrip(@PathVariable("id") Integer id, @RequestBody UpdateTripRequest updateTripRequest) {
        tripService.updateTrip(id, updateTripRequest);
        return ResponseEntity.ok("Trip updated successfully!");
    }
}
