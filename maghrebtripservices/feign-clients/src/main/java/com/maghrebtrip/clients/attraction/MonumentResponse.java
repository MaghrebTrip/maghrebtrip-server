package com.maghrebtrip.clients.attraction;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class MonumentResponse extends AttractionResponse {
    private Integer id;
    private Integer cityId;
    private String name;
    private byte[] image;
    private String type;
    private String description;
    private List<ScheduleResponse> schedules;
    private String location;
    private float rating;
    private int sponsored;
}
