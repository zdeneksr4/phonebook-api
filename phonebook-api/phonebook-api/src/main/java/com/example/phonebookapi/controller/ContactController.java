package com.example.phonebookapi.controller;

import com.example.phonebookapi.dto.ContactDTO;
import com.example.phonebookapi.service.ContactService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// REST controller for managing contacts
@RestController
@RequestMapping("/contacts")
public class ContactController {

    private final ContactService contactService;

    // Constructor injection of ContactService
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    // Endpoint to add new contact
    @PostMapping
    public ResponseEntity<ContactDTO> createContact(@RequestBody ContactDTO contactDTO){
        ContactDTO savedContact = contactService.createContact(contactDTO);
        return new ResponseEntity<>(savedContact, HttpStatus.CREATED);
    }

    // Endpoint to retrieve an existing contact by its ID
    @GetMapping("{id}")
    public ResponseEntity<ContactDTO> getContactById(@PathVariable("id") int contactId){
        ContactDTO contactDTO = contactService.getContactById(contactId);
        return ResponseEntity.ok(contactDTO);
    }

    // Endpoint to retrieve all contacts
    @GetMapping
    public ResponseEntity<List<ContactDTO>> getAllContacts(){
        List<ContactDTO> contacts = contactService.getAllContacts();
        return ResponseEntity.ok(contacts);
    }

    // Endpoint to update an existing contact based on ID
    @PutMapping("{id}")
    public ResponseEntity<ContactDTO> updateContact(@PathVariable("id") int contactId,
                                                    @RequestBody ContactDTO updatedContact){
        ContactDTO contactDTO = contactService.updateContact(contactId, updatedContact);
        return ResponseEntity.ok(contactDTO);
    }

    // Endpoint to delete a contact by its ID
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteContact(@PathVariable("id") int contactId){
        contactService.deleteContact(contactId);
        return ResponseEntity.ok("Contact was successfully deleted!");
    }
}
