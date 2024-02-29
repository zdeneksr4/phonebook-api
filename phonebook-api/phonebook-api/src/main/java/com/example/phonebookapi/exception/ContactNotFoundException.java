package com.example.phonebookapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// Exception class for indicating that a contact does not exist
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ContactNotFoundException extends RuntimeException{

    // Constructor with a message parameter
    public ContactNotFoundException(String msg){
        super(msg); // Passes the message to the superclass constructor
    }
}
