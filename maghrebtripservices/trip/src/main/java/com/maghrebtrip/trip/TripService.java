package com.maghrebtrip.trip;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TripService{
    private final TripRepository tripRepository;


    public List<Trip> getAllTrips() {
        return tripRepository.findAll();
    }
    public String registerTrip(RegisterTripRequest request){
        Trip trip = Trip.builder()
                .touristId(request.touristId())
                .cityId(request.cityId())
                .checkIn(request.checkIn())
                .checkOut(request.checkOut())
                .adults(request.adults())
                .infants(request.infants())
                .pets(request.pets())
                .rooms(request.rooms())
                .build();
        tripRepository.saveAndFlush(trip);
        return "Trip registered successfully!";
    }

    public void updateTrip(Integer id,UpdateTripRequest request){
        Trip trip = tripRepository.findById(id).get();
        trip.setTouristId(request.touristId());
        trip.setCityId(request.cityId());
        trip.setCheckIn(request.checkIn());
        trip.setCheckOut(request.checkOut());
        trip.setAdults(request.adults());
        trip.setInfants(request.infants());
        trip.setPets(request.pets());
        trip.setRooms(request.rooms());
        tripRepository.save(trip);
    }

    public void deleteTrip(Integer id){
        tripRepository.deleteById(id);
    }
}
