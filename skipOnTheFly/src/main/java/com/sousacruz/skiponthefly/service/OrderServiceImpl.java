package com.sousacruz.skiponthefly.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sousacruz.skiponthefly.domain.Order;
import com.sousacruz.skiponthefly.repository.OrderRepository;


@Service
@Transactional
public class OrderServiceImpl implements OrderService {


	@Autowired
	private OrderRepository orderRepository;
	
	@Override
	public List<Order> listOrderByTargetLocation(String locationCode) {
		return orderRepository.findByCustomerLocation(locationCode);
	}

	@Override
	public List<Order> listOrderBySourceLocation(String locationCode) {
		return orderRepository.findByRestaurantLocation(locationCode);
	}
	
	@Override
	public List<Order> listOrderByStatus(String statusCode) {
		return orderRepository.findByStatus(statusCode);
	}
	
	@Override
	public List<Order> listOrderByCourierAssigned(Integer courierId) {
		return orderRepository.findByCourierAssigned(courierId);
	}
	
	@Override
	public Optional<Order> getOrderById(Integer orderId) {
		return orderRepository.findById(orderId);
	}
	
	@Override
	public List<Order> listAll() {
		return orderRepository.findAll();
	}
}