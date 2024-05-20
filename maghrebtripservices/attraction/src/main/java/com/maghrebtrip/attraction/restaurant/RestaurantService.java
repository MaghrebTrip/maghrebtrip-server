package com.maghrebtrip.attraction.restaurant;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.List;

import com.maghrebtrip.attraction.hotel.Hotel;
import com.maghrebtrip.attraction.restaurant.dto.RestaurantRegisterationRequest;
import com.opencsv.CSVReader;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;

    public List<Restaurant> getAllRestaurants() {
      return restaurantRepository.findAll();
    }
    public List<Restaurant> getRestaurantByCityId(Integer cityId) {
        return restaurantRepository.findByCityId(cityId);
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
                .image(request.image())
                .type(request.type())
                .cityId(request.cityId())
                .location(request.location())
                .description(request.description())
                .sponsored(request.sponsored())
                .rating(request.rating())
                .schedules(request.schedules())
                .cuisineType(request.cuisineType())
                .affordability(request.affordability())
                .build();
        restaurantRepository.save(restaurant);
    }

    public void updateRestaurant(Integer id, RestaurantRegisterationRequest request) {
        Restaurant restaurant = restaurantRepository.findById(id).get();
        restaurant.setName(request.name());
        restaurant.setImage(request.image());
        restaurant.setType(request.type());
        restaurant.setCityId(request.cityId());
        restaurant.setLocation(request.location());
        restaurant.setDescription(request.description());
        restaurant.setSponsored(request.sponsored());
        restaurant.setRating(request.rating());
        restaurant.setSchedules(request.schedules());
        restaurant.setCuisineType(request.cuisineType());
        restaurant.setAffordability(request.affordability());
        restaurantRepository.save(restaurant);
    }

    public void deleteRestaurant(Integer id) {
      restaurantRepository.deleteById(id);
    }

    public byte[] getImage(String url) throws IOException {
        URL imageUrl = new URL(url);
        return imageUrl.openStream().readAllBytes();
    }

    public void loadRestaurantsDataFromCSV() {
        // columns: city_id,name,image,type,description,location,rating,schedule,sponsored,cuisine_type,affordability
        String path = "maghrebtripservices/attraction/src/main/resources/restaurants.csv";
        try (CSVReader reader = new CSVReader(new FileReader(path))) {
            String[] lineInArray;
            reader.readNext();
            while ((lineInArray = reader.readNext()) != null) {
                Restaurant restaurant = Restaurant.builder() //TODO: add more columns
                        .cityId(Integer.parseInt(lineInArray[0]))
                        .name(lineInArray[1])
                        .image(getImage(lineInArray[2]))
                        .type(lineInArray[3])
                        .description(lineInArray[4])
                        .location(lineInArray[5])
                        .rating(Float.parseFloat((lineInArray[6])))
                        .schedules(null) //TODO: add schedule
                        .sponsored(Integer.parseInt(lineInArray[8]))
                        .cuisineType(lineInArray[9])
                        .affordability(lineInArray[10])
                        .build();
                restaurantRepository.save(restaurant);
            }
        }
        catch (Exception e) {
          e.printStackTrace();
        }
    }
}
