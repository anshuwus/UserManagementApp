package com.ashokit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ashokit.entity.Country;
import com.ashokit.entity.State;

public interface ICountryRepository  extends JpaRepository<Country, Integer>{
	@Query("select countryId, countryName from Country")
	List<Object[]> getCountryIdAndName();
	
	
}
