package com.ashokit.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Table(name="City_Tab")
@Entity
@Setter
@Getter
public class City {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cityId;
	
	@Column(length = 50)
	private String cityName;
	
	@ManyToOne
	@JoinColumn(name="state_Id", referencedColumnName = "stateId")
	private State state;
}
