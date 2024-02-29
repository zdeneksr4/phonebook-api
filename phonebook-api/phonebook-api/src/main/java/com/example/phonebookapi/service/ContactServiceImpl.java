package com.example.phonebookapi.service;

import com.example.phonebookapi.dto.ContactDTO;
import com.example.phonebookapi.entity.Contact;
import com.example.phonebookapi.exception.ContactNotFoundException;
import com.example.phonebookapi.mapper.ContactMapper;
import com.example.phonebookapi.repository.ContactRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

// Implementation of the ContactService for managing contacts
@Service
public class ContactServiceImpl implements ContactService{

    private final ContactRepository contactRepository;

    // Constructor injection of ContactRepository
    public ContactServiceImpl(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    // Creates new contact based on the provided DTO
    @Override
    public ContactDTO createContact(ContactDTO contactDTO) {
        Contact contact = ContactMapper.mapToContact(contactDTO);
        Contact savedContact = contactRepository.save(contact);
        return ContactMapper.mapToContactDTO(savedContact);
    }

    // Retrieves a contact by its ID
    @Override
    public ContactDTO getContactById(int contactId) {
        Contact contact = contactRepository.findById(contactId)
                .orElseThrow(() -> new ContactNotFoundException("Contact with the given ID does not exist!"));
        return ContactMapper.mapToContactDTO(contact);
    }

    // Retrieves all contacts
    @Override
    public List<ContactDTO> getAllContacts() {
        List<Contact> contacts = contactRepository.findAll();
        return contacts.stream().map(ContactMapper::mapToContactDTO).collect(Collectors.toList());
    }

    // Updates an existing contact based on ID
    @Override
    public ContactDTO updateContact(int contactId, ContactDTO updatedContact) {
        Contact contact = contactRepository.findById(contactId).orElseThrow(
                () -> new ContactNotFoundException("Contact with the given ID does not exist!")
        );
        contact.setFirstName(updatedContact.getFirstName());
        contact.setLastName(updatedContact.getLastName());
        contact.setPhoneNumber(updatedContact.getPhoneNumber());
        Contact updatedContactObject = contactRepository.save(contact);
        return ContactMapper.mapToContactDTO(updatedContactObject);
    }

    // Deletes a contact by its ID
    @Override
    public void deleteContact(int contactId) {
        Contact contact = contactRepository.findById(contactId).orElseThrow(
                () -> new ContactNotFoundException("Contact with the given ID does not exist!")
        );
        contactRepository.deleteById(contactId);
    }
}
