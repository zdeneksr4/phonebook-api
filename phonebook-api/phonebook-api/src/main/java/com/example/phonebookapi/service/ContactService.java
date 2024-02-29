package com.example.phonebookapi.service;

import com.example.phonebookapi.dto.ContactDTO;

import java.util.List;

// Service interface for managing contacts
public interface ContactService {
    // Creates new contact based on the provided DTO
    ContactDTO createContact(ContactDTO contactDTO);

    // Retrieves a contact by its ID
    ContactDTO getContactById(int contactId);

    // Retrieves all contacts
    List<ContactDTO> getAllContacts();

    // Updates an existing contact based on ID
    ContactDTO updateContact(int contactId, ContactDTO updatedContact);

    // Deletes a contact by its ID
    void deleteContact(int contactId);
}
