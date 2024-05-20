package com.maghrebtrip.plan;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/plans/")
@AllArgsConstructor
public class PlanController {
    private final PlanService planService;

    @GetMapping("all")
    public List<Plan> getAllPlans() {
        return planService.getAllPlans();
    }

    @GetMapping("{cityId}")
    public List<Plan> getPlansByCity(@PathVariable("cityId") Integer cityId) { return planService.getPlansByCityId(cityId); }

    @PostMapping("new")
    public ResponseEntity<String> registerPlan(@RequestBody PlanRequest planRequest) {
        String response = planService.registerPlan(planRequest);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteCity(@PathVariable("id") Integer id) {
        planService.deletePlan(id);
        return ResponseEntity.ok("Plan deleted successfully!");
    }

    @PutMapping("update/{id}")
    public ResponseEntity<String> updatePlan(@PathVariable("id") Integer id, @RequestBody PlanRequest planRequest) {
        planService.updatePlan(id, planRequest);
        return ResponseEntity.ok("Plan updated successfully!");
    }
}
