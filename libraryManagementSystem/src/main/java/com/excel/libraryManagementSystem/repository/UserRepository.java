package com.excel.libraryManagementSystem.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.excel.libraryManagementSystem.dto.UserDto;
import com.excel.libraryManagementSystem.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	Optional<User> findByEmail(String email);
	
	Optional<User> findByName(String name);

	String deleteById(User userEntity);
}
