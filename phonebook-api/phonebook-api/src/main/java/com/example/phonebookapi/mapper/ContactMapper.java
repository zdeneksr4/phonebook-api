package com.example.phonebookapi.mapper;

import com.example.phonebookapi.dto.ContactDTO;
import com.example.phonebookapi.entity.Contact;

// Mapper class for converting Contact and ContactDTO objects
public class ContactMapper {

    // Converts Contact to ContactDTO
    public static ContactDTO mapToContactDTO(Contact contact){
        return new ContactDTO(
            contact.getId(),
            contact.getFirstName(),
            contact.getLastName(),
            contact.getPhoneNumber()
        );
    }

    // Converts ContactDTO to Contact
    public static Contact mapToContact(ContactDTO contactDTO){
        return new Contact(
                contactDTO.getId(),
                contactDTO.getFirstName(),
                contactDTO.getLastName(),
                contactDTO.getPhoneNumber()
        );
    }
}
