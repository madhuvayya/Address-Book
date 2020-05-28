package com.addressbook;

public class PersonDAO {

    String firstName;
    String lastName;
    String address;
    String city;
    String state;
    String zip;
    String phone;

    public PersonDAO(String firstName, String lastName, String address, String city, String state, String zip,
                     String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phone = phone;
    }
}
