package com.maghrebtrip.attraction.restaurant;

import com.maghrebtrip.attraction.restaurant.dto.RestaurantRegisterationRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/attractions/restaurants/")
public class RestaurantController {

  private final RestaurantService restaurantService;

  @GetMapping("all")
  public List<Restaurant> getAllRestaurants() {
    return restaurantService.getAllRestaurants();
  }

  @GetMapping("city={cityId}")
  public List<Restaurant> getRestaurantByCityId(@PathVariable("cityId") Integer cityId) {return restaurantService.getRestaurantByCityId(cityId);}

  @GetMapping("name={name}")
  public Restaurant getRestaurantByName(@PathVariable("name") String name) {
    return restaurantService.getRestaurantByName(name);
  }

  @GetMapping("location={location}")
  public List<Restaurant> getRestaurantsByLocation(@PathVariable("location") String location) {
    return restaurantService.getRestaurantsByLocation(location);
  }

  @PostMapping("new")
  public ResponseEntity<String> registerRestaurant(@RequestBody RestaurantRegisterationRequest request) {
    restaurantService.registerRestaurant(request);
    return ResponseEntity.ok("Restaurant registered successfully");
  }

  @PutMapping("update/id={id}")
  public void updateRestaurant(@PathVariable("id") Integer id, @RequestBody RestaurantRegisterationRequest restaurantRegisterationRequest) {
    restaurantService.updateRestaurant(id, restaurantRegisterationRequest);
  }

  @DeleteMapping("delete/id={id}")
  public void deleteRestaurant(@PathVariable("id") Integer id) {
    restaurantService.deleteRestaurant(id);
  }

}
