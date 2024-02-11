package com.ashokit.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="User_Info_Tab")
@Getter
@Setter
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;
	
	@Column(length = 30)
	private String firstName;
	
	@Column(length = 30)
	private String lastName;
	
	@Column(length = 60)
	private String email;
	private Long phno;
	private LocalDate dob;
	
	@Column(length = 10)
	private String gender;
	
	@Column(length = 10)
	private String status;
	
	private String pwd;
	
	@ManyToOne(targetEntity = Country.class, cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	@JoinColumn(name="counrty_id", referencedColumnName = "countryId")
	private Country country;

	@ManyToOne(targetEntity = State.class, cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	@JoinColumn(name="state_id", referencedColumnName = "stateId")
	private State state;

	@ManyToOne(targetEntity = City.class, cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	@JoinColumn(name="city_id", referencedColumnName = "cityId")
	private City city;

	//toString
	@Override
	public String toString() {
		return "User [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", dob=" + dob + ", gender=" + gender + "]";
	}

	//0-param constructor
	public User() {
		System.out.println("User.User()");
	}
	
	
	
}
