package com.sousacruz.skiponthefly.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.sousacruz.skiponthefly.domain.Restaurant;
import com.sousacruz.skiponthefly.service.RestaurantService;

@RestController
public class RestaurantController {
	
	private static final Logger log = LoggerFactory.getLogger(RestaurantController.class);
	
	@Autowired
	private RestaurantService restaurantService;
	
	@GetMapping(path = "/restaurant")
	public ResponseEntity<?> listAll() {
		List<Restaurant> list = restaurantService.listAll();
		return new ResponseEntity<List<Restaurant>>(list, HttpStatus.OK);
	}
	
	@GetMapping(path = "/restaurant/{id}")
	public ResponseEntity<?> getRestaurantById(@PathVariable("id") Integer restaurantId) {
		Optional<Restaurant> restaurant = restaurantService.getRestaurantById(restaurantId);
		if (restaurant.isPresent())
			return new ResponseEntity<Restaurant>(restaurant.get(), HttpStatus.OK);
		return new ResponseEntity<String>("Couldn't retrieve for given restaurant.", HttpStatus.NOT_FOUND);
	}
	
	@GetMapping(path = "/restaurant/{locationCode}")
	public ResponseEntity<?> getRestaurantById(@PathVariable("locationCode") String locationCode) {
		List<Restaurant> list = restaurantService.listRestaurantByLocation(locationCode);
		return new ResponseEntity<List<Restaurant>>(list, HttpStatus.OK);
	}
}