package com.sousacruz.skiponthefly.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sousacruz.skiponthefly.domain.Restaurant;
import com.sousacruz.skiponthefly.repository.RestaurantRepository;


@Service
@Transactional
public class RestaurantServiceImpl implements RestaurantService {


	@Autowired
	private RestaurantRepository restaurantRepository;
	

	@Override
	public List<Restaurant> listRestaurantByLocation(String locationCode) {
		return restaurantRepository.findByLocationCode(locationCode);
	}

	@Override
	public Optional<Restaurant> getRestaurantById(Integer restaurantId) {
		return restaurantRepository.findById(restaurantId);
	}
	
	@Override
	public List<Restaurant> listAll() {
		return restaurantRepository.findAll();	
	}

}