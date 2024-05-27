package com.maghrebtrip.feedback.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;


@Builder
@Data
public class FeedbackResponse {
    Integer id;
    String touristFirstName;
    String touristLastName;
    float rating;
    String comment;
    LocalDateTime date;
}
