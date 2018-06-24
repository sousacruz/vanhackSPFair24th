package com.sousacruz.skiponthefly.service;

import java.util.List;
import java.util.Optional;

import com.sousacruz.skiponthefly.domain.Customer;

public interface CustomerService {
	
	List<Customer> listCustomerByLocation(String locationCode);
	
	Optional<Customer> getCustomerById(Integer restaurantId);
	
	List<Customer> listAll();
}
