package com.maghrebtrip.attraction.restaurant;

import com.maghrebtrip.attraction.restaurant.dto.RestaurantRegisterationRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@AllArgsConstructor
@NoArgsConstructor(force = true)
@RequestMapping("/api/restaurants")
public class RestaurantController {

  private final RestaurantService restaurantService;

  @GetMapping("/get/all")
  public List<Restaurant> getAllRestaurants() {
    return restaurantService.getAllRestaurants();
  }

  @GetMapping("/get/name={name}")
  public Restaurant getRestaurantByName(@PathVariable("name") String name) {
    return restaurantService.getRestaurantByName(name);
  }

  @GetMapping("/get/location={location}")
  public List<Restaurant> getRestaurantsByLocation(@PathVariable("location") String location) {
    return restaurantService.getRestaurantsByLocation(location);
  }

  @PostMapping("/new")
  public ResponseEntity<String> registerRestaurant(@RequestBody RestaurantRegisterationRequest request) {
    restaurantService.registerRestaurant(request);
    return ResponseEntity.ok("Restaurant registered successfully");
  }

  @PutMapping("/update/id={id}")
  public void updateRestaurant(@PathVariable("id") Integer id, @RequestBody RestaurantRegisterationRequest restaurantRegisterationRequest) {
    restaurantService.updateRestaurant(id, restaurantRegisterationRequest);
  }

  @DeleteMapping("/delete/id={id}")
  public void deleteRestaurant(@PathVariable("id") Integer id) {
    restaurantService.deleteRestaurant(id);
  }


}
