package com.maghrebtrip.clients.attraction;

import lombok.Data;

import java.io.Serializable;
import java.util.List;


@Data
public class AttractionResponse implements Serializable {
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
