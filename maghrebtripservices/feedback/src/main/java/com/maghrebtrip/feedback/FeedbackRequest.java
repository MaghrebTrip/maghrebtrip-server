package com.maghrebtrip.feedback;

public record FeedbackRequest(
        Integer touristId,
        Integer attractionId,
        String rating,
        String comment
) {
}