package com.sousacruz.skiponthefly.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sousacruz.skiponthefly.domain.Customer;
import com.sousacruz.skiponthefly.repository.CustomerRepository;


@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {


	@Autowired
	private CustomerRepository customerRepository;
	

	@Override
	public List<Customer> listCustomerByLocation(String locationCode) {
		return customerRepository.findByLocationCode(locationCode);
	}

	@Override
	public Optional<Customer> getCustomerById(Integer restaurantId) {
		return customerRepository.findById(restaurantId);
	}

	@Override
	public List<Customer> listAll() {
		return customerRepository.findAll();
	}
}