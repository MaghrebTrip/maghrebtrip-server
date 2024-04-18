package com.maghrebtrip.attraction;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Schedule {

    private String dayOfWeek;
    private String startTime;
    private String endTime;

}
