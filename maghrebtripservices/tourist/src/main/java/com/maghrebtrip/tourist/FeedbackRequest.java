package com.maghrebtrip.tourist;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FeedbackRequest {
    private Integer touristId;
    private String rating;
    private String comment;
}
