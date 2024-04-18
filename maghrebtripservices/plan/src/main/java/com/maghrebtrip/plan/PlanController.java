package com.maghrebtrip.plan;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/plans")
@AllArgsConstructor
public class PlanController {
    private final PlanServcie planServcie;

    @GetMapping("all")
    public List<Plan> getAllPlans() {
        return planServcie.getAllPlans();
    }

    @PostMapping("new")
    public ResponseEntity<String> registerPlan(@RequestBody PlanRequest planRequest) {
        String response = planServcie.registerPlan(planRequest);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteCity(@PathVariable("id") Integer id) {
        planServcie.deletePlan(id);
        return ResponseEntity.ok("Plan deleted successfully!");
    }

    @PutMapping("update/{id}")
    public ResponseEntity<String> updatePlan(@PathVariable("id") Integer id, @RequestBody PlanRequest planRequest) {
        planServcie.updatePlan(id, planRequest);
        return ResponseEntity.ok("Plan updated successfully!");
    }
}
