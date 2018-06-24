package com.sousacruz.skiponthefly.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sousacruz.skiponthefly.domain.Order;
import com.sousacruz.skiponthefly.domain.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant, Integer>{
	
	@Query(value = "SELECT r FROM Restaurant r WHERE r.id = :restaurantId ")
	public Optional<Restaurant> findById(@Param("restaurantId") Integer restaurantId);
	
	@Query(value = "SELECT r FROM Restaurant r WHERE r.locationCode = :locationCode ")
	public List<Restaurant> findByLocationCode(@Param("locationCode") String locationCode);
	
	@Query(value = "SELECT r FROM Restaurant r")
	public List<Order> listAll();
		
}