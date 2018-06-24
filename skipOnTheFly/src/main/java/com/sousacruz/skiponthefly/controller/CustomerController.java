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

import com.sousacruz.skiponthefly.domain.Customer;
import com.sousacruz.skiponthefly.service.CustomerService;

@RestController
public class CustomerController {
	
	private static final Logger log = LoggerFactory.getLogger(RestaurantController.class);
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping(path = "/customer")
	public ResponseEntity<?> listAll() {
		List<Customer> list = customerService.listAll();
		return new ResponseEntity<List<Customer>>(list, HttpStatus.OK);
	}
	
	@GetMapping(path = "/customer/{id}")
	public ResponseEntity<?> getRestaurantById(@PathVariable("id") Integer customerId) {
		Optional<Customer> restaurant = customerService.getCustomerById(customerId);
		if (restaurant.isPresent())
			return new ResponseEntity<Customer>(restaurant.get(), HttpStatus.OK);
		return new ResponseEntity<String>("Couldn't retrieve for given customer.", HttpStatus.NOT_FOUND);
	}
	
	@GetMapping(path = "/customer/{locationCode}")
	public ResponseEntity<?> getRestaurantById(@PathVariable("locationCode") String locationCode) {
		List<Customer> list = customerService.listCustomerByLocation(locationCode);
		return new ResponseEntity<List<Customer>>(list, HttpStatus.OK);
	}
}