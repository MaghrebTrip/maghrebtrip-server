package com.maghrebtrip.attraction.entertainment;

import com.maghrebtrip.attraction.entertainment.Entertainment;
import com.maghrebtrip.attraction.entertainment.EntertainmentService;
import com.maghrebtrip.attraction.entertainment.dto.EntertainmentRegistrationRequest;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@AllArgsConstructor
@NoArgsConstructor(force = true)
@RequestMapping("/api/entertainments")
public class EntertainmentController {

    private final EntertainmentService entertainmentService;

    @GetMapping("/get/all")
    public List<Entertainment> getAllEntertainments() {
        return entertainmentService.getAllEntertainments();
    }

    @PostMapping("/new")
    public ResponseEntity<String> registerEntertainment(@RequestBody EntertainmentRegistrationRequest request) {
        entertainmentService.registerEntertainment(request);
        return ResponseEntity.ok("Entertainment registered successfully");
    }

    @PutMapping("/update/id={id}")
    public void updateEntertainment(@PathVariable("id") Integer id, @RequestBody EntertainmentRegistrationRequest entertainmentRegisterationRequest) {
        entertainmentService.updateEntertainment(id, entertainmentRegisterationRequest);
    }

    @DeleteMapping("/delete/id={id}")
    public void deleteEntertainment(@PathVariable("id") Integer id) {
        entertainmentService.deleteEntertainment(id);
    }



}

