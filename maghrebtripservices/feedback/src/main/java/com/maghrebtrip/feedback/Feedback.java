package com.maghrebtrip.feedback;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Feedback {

    @Id
    @SequenceGenerator(
            name = "feedback_id_sequence",
            sequenceName = "feedback_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "feedback_id_sequence"
    )
    private Integer id;
    private Integer touristId;
    private Integer attractionId;
    private String attractionType;
    private float rating;
    private String comment;
    private LocalDateTime date;
    private boolean edited = false;
}
