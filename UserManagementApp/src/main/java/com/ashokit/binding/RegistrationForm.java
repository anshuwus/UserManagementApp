package com.ashokit.binding;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import com.ashokit.entity.City;
import com.ashokit.entity.Country;
import com.ashokit.entity.State;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class RegistrationForm {

	private String firstName;

	private String lastName;

	private String email;
	
	private Long phno;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate dob;

	private String gender;
	
	private Country country;
	
	private State state;
	
	private City city;

}
