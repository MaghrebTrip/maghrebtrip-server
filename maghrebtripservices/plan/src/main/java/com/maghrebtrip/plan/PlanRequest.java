package com.maghrebtrip.plan;

import com.maghrebtrip.attraction.Attraction;

import java.util.List;

public record PlanRequest(
        Integer cityId,
        List<Attraction> attractions
) {
}
