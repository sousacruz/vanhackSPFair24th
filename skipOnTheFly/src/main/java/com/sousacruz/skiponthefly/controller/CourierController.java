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

import com.sousacruz.skiponthefly.domain.Courier;
import com.sousacruz.skiponthefly.service.CourierService;

@RestController
public class CourierController {
	
	private static final Logger log = LoggerFactory.getLogger(RestaurantController.class);
	
	@Autowired
	private CourierService courierService;
	
	@GetMapping(path = "/courier")
	public ResponseEntity<?> listAll() {
		List<Courier> list = courierService.listAll();
		return new ResponseEntity<List<Courier>>(list, HttpStatus.OK);
	}
	
	@GetMapping(path = "/courier/{id}")
	public ResponseEntity<?> getCourierById(@PathVariable("id") Integer restaurantId) {
		Optional<Courier> courier = courierService.getCourierById(restaurantId);
		if (courier.isPresent())
			return new ResponseEntity<Courier>(courier.get(), HttpStatus.OK);
		return new ResponseEntity<String>("Couldn't retrieve for given courier.", HttpStatus.NOT_FOUND);
	}
	
	@GetMapping(path = "/courier/{name}")
	public ResponseEntity<?> getCourierByName(@PathVariable("name") String name) {
		List<Courier> list = courierService.listCourierByName(name);
		return new ResponseEntity<List<Courier>>(list, HttpStatus.OK);
	}
	
	@GetMapping(path = "/courier/availables")
	public ResponseEntity<?> getCourierByAvalabitiy() {
		List<Courier> list = courierService.listAvailables();
		return new ResponseEntity<List<Courier>>(list, HttpStatus.OK);
	}
}