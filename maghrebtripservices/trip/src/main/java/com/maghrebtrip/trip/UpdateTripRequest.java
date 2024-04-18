package com.maghrebtrip.trip;

import java.util.Date;

public record UpdateTripRequest(
        Integer touristId,
        Integer cityId,
        Date checkIn,
        Date checkOut,
        int adults,
        int infants,
        int pets,
        int rooms
) {
}
