package com.example.phonebookapi.repository;

import com.example.phonebookapi.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

// Repository interface for managing contacts using Spring Data JPA
public interface ContactRepository extends JpaRepository<Contact, Integer> {
}
