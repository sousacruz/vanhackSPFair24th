package com.sousacruz.skiponthefly.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sousacruz.skiponthefly.domain.Customer;
import com.sousacruz.skiponthefly.domain.Order;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{
	
	@Query(value = "SELECT c FROM Customer c WHERE c.id = :customerId ")
	public Optional<Customer> findById(@Param("customerId") Integer customerId);
	
	@Query(value = "SELECT c FROM Customer c WHERE c.locationCode = :locationCode ")
	public List<Customer> findByLocationCode(@Param("locationCode") String locationCode);
	
	@Query(value = "SELECT c FROM Customer c")
	public List<Order> listAll();
	
}