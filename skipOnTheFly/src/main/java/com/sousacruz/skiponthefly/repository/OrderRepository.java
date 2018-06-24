package com.sousacruz.skiponthefly.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sousacruz.skiponthefly.domain.Order;

public interface OrderRepository extends JpaRepository<Order, Integer>{ 

	@Query(value = "SELECT o FROM Order o INNER JOIN Customer c ON c.id = o.customer.id WHERE c.locationcode = :locationCode")
	public List<Order> findByCustomerLocation(@Param("locatioCode") String locationCode);
	
	@Query(value = "SELECT o FROM Order o INNER JOIN Restaurant r ON r.id = o.restaurant.id WHERE c.locationcode = :locationCode")
	public List<Order> findByRestaurantLocation(@Param("locationCode") String locationCode);
	
	@Query(value = "SELECT o FROM Order o WHERE o.status = :statusCode")
	public List<Order> findByStatus(@Param("statusCode") String statusCode); 
	
	@Query(value = "SELECT o FROM Order o INNER JOIN Courier c ON c.id = o.courier.id WHERE c.id = :courierId")
	public List<Order> findByCourierAssigned(@Param("courierId") Integer courierId);
	
	@Query(value = "SELECT o FROM Order o")
	public List<Order> findAll();
	
}