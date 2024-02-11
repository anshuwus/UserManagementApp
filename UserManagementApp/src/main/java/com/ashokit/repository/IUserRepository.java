package com.ashokit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ashokit.entity.User;

public interface IUserRepository extends JpaRepository<User, Integer>{
	@Query("select count(email) from User where email=:email")
	Integer getEmailCount(String email);
	
	@Query("from User where email=:email")
	User getUserAccount(String email);
}
