package com.addressbook;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AddressBook {

    List<Person> addressBookList = new ArrayList<Person>();

    public void add(String firstName, String lastName, String address, String city, String state, String zip,
                    String phone) {
        Person person = new Person(firstName, lastName, address, city, state, zip, phone);
        addressBookList.add(person);
    }

}
