package com.excel.libraryManagementSystem.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.excel.libraryManagementSystem.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer>{

	Optional<Admin> findByAdminId(String adminId);

}
