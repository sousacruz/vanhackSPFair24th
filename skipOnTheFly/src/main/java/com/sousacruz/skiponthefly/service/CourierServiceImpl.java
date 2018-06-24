package com.sousacruz.skiponthefly.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sousacruz.skiponthefly.domain.Courier;
import com.sousacruz.skiponthefly.repository.CourierRepository;


@Service
@Transactional
public class CourierServiceImpl implements CourierService {

	@Autowired
	private CourierRepository courierRepository;
	
	@Override
	public List<Courier> listCourierByName(String name) {
		return courierRepository.findByName(name);
	}

	@Override
	public Optional<Courier> getCourierById(Integer courierId) {
		return courierRepository.findById(courierId);
	}

	@Override
	public List<Courier> listAll() {
		return courierRepository.findAll();
	}
	
	@Override
	public List<Courier> listAvailables() {
		return courierRepository.findAvailables();
	}
}