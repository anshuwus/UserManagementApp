package com.ashokit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashokit.entity.State;

public interface IStateRepository extends JpaRepository<State, Integer>{
	
	
}
