package com.sousacruz.skiponthefly.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sousacruz.skiponthefly.domain.Courier;

public interface CourierRepository extends JpaRepository<Courier, Integer>{
	
	@Query(value = "SELECT c FROM Courier c WHERE c.id = :courierId ")
	public Optional<Courier> findById(@Param("courierId") Integer courierId);
	
	@Query(value = "SELECT c FROM Courier c WHERE c.name like :courierName ")
	public List<Courier> findByName(@Param("courierName") String courierName);
	
	@Query(value = "SELECT c FROM Courier c")
	public List<Courier> findAll();
	
	@Query(value = "SELECT c FROM Courier c WHERE c.status = 'Online'")
	public List<Courier> findAvailables();
	
}