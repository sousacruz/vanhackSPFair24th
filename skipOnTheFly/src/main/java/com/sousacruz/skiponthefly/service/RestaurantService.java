package com.sousacruz.skiponthefly.service;

import java.util.List;
import java.util.Optional;

import com.sousacruz.skiponthefly.domain.Restaurant;

public interface RestaurantService {

	List<Restaurant> listRestaurantByLocation(String locationCode);
	
	Optional<Restaurant> getRestaurantById(Integer restaurantId);
	
	List<Restaurant> listAll();
	
}