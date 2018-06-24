package com.sousacruz.skiponthefly.domain;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Order {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column
	private String status;
	
	@JsonIgnore
	@OneToMany(mappedBy="courier", fetch=FetchType.LAZY)
	private Courier courier;

	@JsonIgnore
	@ManyToOne
	private Customer customer;
	
	@JsonIgnore
	@ManyToOne
	private Restaurant restaurant;

}
