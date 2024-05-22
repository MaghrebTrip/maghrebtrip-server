package com.maghrebtrip.plan;

import com.maghrebtrip.clients.attraction.AttractionResponse;

import java.util.List;

public record PlanRequest(
        Integer cityId,
        List<AttractionResponse> attractions
) {
}
