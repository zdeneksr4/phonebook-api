package com.example.phonebookapi.entity;

import jakarta.persistence.*;


// Entity class representing a contact in the phonebook
@Entity
@Table(name = "contacts")
public class Contact {

    // Primary key
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // First name of the contact, cannot be null
    @Column(name = "first_name", nullable = false)
    private String firstName;

    // Last name of the contact, cannot be null
    @Column(name = "last_name", nullable = false)
    private String lastName;

    // Phone number of the contact, cannot be null, must be unique
    @Column(name = "phone_number", nullable = false, unique = true)
    private String phoneNumber;

    // No Args constructor (required by JPA)
    public Contact(){}

    // Constructor for initializing contact with all fields
    public Contact(int id, String firstName, String lastName, String phoneNumber) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    // Getters and Setters for all the fields
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
