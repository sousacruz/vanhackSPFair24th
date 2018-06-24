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

import com.sousacruz.skiponthefly.domain.Order;
import com.sousacruz.skiponthefly.domain.Customer;
import com.sousacruz.skiponthefly.domain.Restaurant;
import com.sousacruz.skiponthefly.service.OrderService;
import com.sousacruz.skiponthefly.service.CustomerService;
import com.sousacruz.skiponthefly.service.RestaurantService;

@RestController
public class OrderController {
	
	private static final Logger log = LoggerFactory.getLogger(RestaurantController.class);
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private RestaurantService restaurantService;
	
	@GetMapping(path = "/order")
	public ResponseEntity<?> listAll() {
		List<Order> list = orderService.listAll();
		return new ResponseEntity<List<Order>>(list, HttpStatus.OK);
	}
	
	@GetMapping(path = "/order/{id}")
	public ResponseEntity<?> getOrderById(@PathVariable("id") Integer orderId) {
		Optional<Order> restaurant = orderService.getOrderById(orderId);
		if (restaurant.isPresent())
			return new ResponseEntity<Order>(restaurant.get(), HttpStatus.OK);
		return new ResponseEntity<String>("Couldn't retrieve for given order.", HttpStatus.NOT_FOUND);
	}
	
	@GetMapping(path = "/order/target/{locationCode}")
	public ResponseEntity<?> getOrderByTargetLocation(@PathVariable("locationCode") String locationCode) {
		List<Order> list = orderService.listOrderByTargetLocation(locationCode);
		return new ResponseEntity<List<Order>>(list, HttpStatus.OK);
	}
	
	@GetMapping(path = "/order/source/{locationCode}")
	public ResponseEntity<?> getOrderBySourceLocation(@PathVariable("locationCode") String locationCode) {
		List<Order> list = orderService.listOrderBySourceLocation(locationCode);
		return new ResponseEntity<List<Order>>(list, HttpStatus.OK);
	}
	
	@GetMapping(path = "/order/{courierId}")
	public ResponseEntity<?> getOrderBySourceLocation(@PathVariable("courierId") Integer courierId) {
		List<Order> list = orderService.listOrderByCourierAssigned(courierId);
		return new ResponseEntity<List<Order>>(list, HttpStatus.OK);
	}
}