package com.A7meD.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.A7meD.springboot.models.UserDtls;

public interface UserRepository extends JpaRepository<UserDtls, Integer> {

	public UserDtls findByEmail(String email);

}
