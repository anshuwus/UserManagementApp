package com.ashokit.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Table(name="State_Tab")
@Entity
@Setter
@Getter
public class State {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer stateId;
	
	@Column(length = 50)
	private String stateName;
	
	@ManyToOne
	@JoinColumn(name="country_Id", referencedColumnName = "countryId")
	private Country country;
	
	@OneToMany(mappedBy = "state" ,fetch = FetchType.EAGER)
	private List<City> city;

	//0-param contsructor
	public State() {
		System.out.println("State.State()");
	}

	//toString
	@Override
	public String toString() {
		return "State [stateId=" + stateId + ", stateName=" + stateName + "]";
	}
	
	
	
	
}
