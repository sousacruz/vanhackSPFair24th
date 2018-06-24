package com.sousacruz.skiponthefly.service;

import java.util.List;
import java.util.Optional;

import com.sousacruz.skiponthefly.domain.Courier;

public interface CourierService {
	
	List<Courier> listCourierByName(String name);
	
	Optional<Courier> getCourierById(Integer courierId);
	
	List<Courier> listAll();
	
	List<Courier> listAvailables();
}
