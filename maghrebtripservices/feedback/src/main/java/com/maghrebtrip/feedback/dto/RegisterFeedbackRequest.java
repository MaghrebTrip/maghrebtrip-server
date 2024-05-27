package com.maghrebtrip.feedback.dto;

public record RegisterFeedbackRequest(
        Integer touristId,
        Integer attractionId,
        String attractionType,
        float rating,
        String comment
) {
}