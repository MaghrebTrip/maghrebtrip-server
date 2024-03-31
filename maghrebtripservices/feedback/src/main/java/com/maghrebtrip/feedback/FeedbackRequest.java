package com.maghrebtrip.feedback;

public record FeedbackRequest(
        Integer touristId,
        String rating,
        String comment
) {
}