package com.maghrebtrip.clients.tourist;

import com.maghrebtrip.clients.tourist.dto.GetTouristResponse;
import com.maghrebtrip.clients.tourist.dto.RegisterTouristRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


@FeignClient(name = "tourist", url = "${clients.tourist.url}")
public interface TouristClient {

    @GetMapping(path = "/all")
    List<RegisterTouristRequest> getAllTourists();

    @PostMapping("/new")
    public ResponseEntity<String> registerTourist(@RequestBody RegisterTouristRequest registerTouristRequest);

    @GetMapping("tourist/id={id}")
    public GetTouristResponse getTouristById(@PathVariable("id") Integer id);
}