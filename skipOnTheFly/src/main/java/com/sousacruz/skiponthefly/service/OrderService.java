package com.sousacruz.skiponthefly.service;

import java.util.List;
import java.util.Optional;

import com.sousacruz.skiponthefly.domain.Order;

public interface OrderService {
	
	List<Order> listOrderByTargetLocation(String locationCode);

	List<Order> listOrderBySourceLocation(String locationCode);
	
	List<Order> listOrderByStatus(String statusCode);
	
	List<Order> listOrderByCourierAssigned(Integer courierId);
	
	Optional<Order> getOrderById(Integer orderId);
	
	List<Order> listAll();
	
	
	
}