package com.maghrebtrip.plan;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PlanServcie {

    private final PlanRepository planRepository;

    public List<Plan> getAllPlans() {
        return planRepository.findAll();
    }

    public String registerPlan(PlanRequest request){
        Plan plan = Plan.builder()
                .cityId(request.cityId())
                .attractions(request.attractions())
                .build();
        return "Plan registered successfully";
    }

    public void updatePlan(Integer id, PlanRequest request) {
        Plan plan = planRepository.findById(id).get();
        plan.setCityId(request.cityId());
        plan.setAttractions(request.attractions());
        planRepository.save(plan);
    }

    public void deletePlan(Integer id) {
        planRepository.deleteById(id);
    }
}
