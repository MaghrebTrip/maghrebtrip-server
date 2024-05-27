package com.maghrebtrip.feedback.dto;

import java.time.LocalDateTime;

public interface FeedbackResponseProjection {
    String getTouristFirstName();
    String getTouristLastName();
    String getAttractionName();
    float getRating();
    String getComment();
    LocalDateTime getDate();
}