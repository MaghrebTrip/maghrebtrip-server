package com.maghrebtrip.plan;

import com.maghrebtrip.clients.attraction.*;
import com.maghrebtrip.clients.city.CityClient;
import com.maghrebtrip.clients.city.CityResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


@Service
@AllArgsConstructor
public class PlanService {

    private final PlanRepository planRepository;
    private final CityClient cityClient;
    private final AttractionClient attractionClient;

    public List<Plan> getAllPlans() {
        return planRepository.findAll();
    }

    public List<Plan> getPlansByCityId(Integer cityId) { return planRepository.findByCityId(cityId); }

    public String registerPlan(PlanRequest request){
        Plan plan = Plan.builder()
                .cityId(request.cityId())
//                .attractions(request.attractions())
                .build();
        return "Plan registered successfully";
    }

    public void updatePlan(Integer id, PlanRequest request) {
        Plan plan = planRepository.findById(id).get();
        plan.setCityId(request.cityId());
//        plan.setAttractions(request.attractions());
        planRepository.save(plan);
    }

    public void deletePlan(Integer id) {
        planRepository.deleteById(id);
    }

    public void generatePlans() {
        List<CityResponse> cities = cityClient.getAllCities();
        if ( cities!=null ) {
            for (CityResponse city : cities) {
                List<HotelResponse> hotels = attractionClient.getHotelByCityId(city.getId());
                List<RestaurantResponse> restaurants = attractionClient.getRestaurantByCityId(city.getId());
                List<MonumentResponse> monuments = attractionClient.getMonumentByCityId(city.getId());
                if (!hotels.isEmpty() && !restaurants.isEmpty() && !monuments.isEmpty()) {
                    for (int i = 0; i < 2; i++) {
                        Plan plan = new Plan();
                        plan.setCityId(city.getId());
                        List<AttractionResponse> attractions = new ArrayList<>();
                        int randomHotel = new Random().nextInt(hotels.size());
                        int randomRestaurant = new Random().nextInt(restaurants.size());
                        int randomMonument = new Random().nextInt(monuments.size());
                        attractions.add(hotels.get(randomHotel));
                        attractions.add(restaurants.get(randomRestaurant));
                        attractions.add(monuments.get(randomMonument));
                        plan.setAttractions(attractions);
                        planRepository.save(plan);
                    }
                }
            }
        }
    }
}


