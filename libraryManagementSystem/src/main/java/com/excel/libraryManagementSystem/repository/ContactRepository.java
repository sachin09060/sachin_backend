package com.excel.libraryManagementSystem.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.excel.libraryManagementSystem.entity.Contact;

public interface ContactRepository extends JpaRepository<Contact, Integer>{

	Optional<Contact> findByContactEmail(String contactEmail);

}
