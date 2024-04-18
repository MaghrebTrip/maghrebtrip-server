package com.maghrebtrip.trip;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface TripRepository extends JpaRepository<Trip, Integer> {

    //List<Trip> findByDatesContainingIgnoreCase(Date StartDate, Date EndDate);
}






