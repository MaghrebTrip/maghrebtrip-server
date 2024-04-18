package com.maghrebtrip.attraction.restaurant;

import java.util.List;

import com.maghrebtrip.attraction.restaurant.dto.RestaurantRegisterationRequest;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RestaurantService {

  private final RestaurantRepository restaurantRepository;

  public List<Restaurant> getAllRestaurants() {
    return restaurantRepository.findAll();
  }

  public Restaurant getRestaurantByName(String name) {
    return (Restaurant) restaurantRepository.findByName(name);
  }

  public List<Restaurant> getRestaurantsByLocation(String location) {
    return restaurantRepository.findByLocation(location);
  }

  public void registerRestaurant(RestaurantRegisterationRequest request) {
    Restaurant restaurant;
    restaurant = Restaurant.builder()
        .name(request.name())
        .cityId(request.cityId())
        .location(request.location())
        .description(request.description())
        .email(request.email())
        .phone(request.phone())
        .sponsored(request.sponsored())
        .cuisineType(request.cuisineType())
        .affordability(request.affordability())
        .build();

    restaurantRepository.save(restaurant);
  }

  public void updateRestaurant(Integer id, RestaurantRegisterationRequest request) {
    Restaurant restaurant = restaurantRepository.findById(id).get();
    restaurant.setName(request.name());
    restaurant.setCityId(request.cityId());
    restaurant.setLocation(request.location());
    restaurant.setDescription(request.description());
    restaurant.setEmail(request.email());
    restaurant.setPhone(request.phone());
    restaurant.setSponsored(request.sponsored());
    restaurant.setCuisineType(request.cuisineType());
    restaurant.setAffordability(request.affordability());

    restaurantRepository.save(restaurant);
  }

  public void deleteRestaurant(Integer id) {
    restaurantRepository.deleteById(id);
  }
}
