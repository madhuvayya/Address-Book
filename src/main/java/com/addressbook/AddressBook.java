package com.addressbook;

import java.util.ArrayList;
import java.util.List;

public class AddressBook {

    List<Person> addressBookList = new ArrayList<Person>();

    public void add(String firstName, String lastName, String address, String city, String state, String zip,
                    String phone) {
        Person person = new Person(firstName, lastName, address, city, state, zip, phone);
        addressBookList.add(person);
    }


    public boolean search(String firstName) {
        for (int i=0;i<addressBookList.size();i++) {
            String name = addressBookList.get(i).firstName;
            if (name.equals(firstName))
                return true;
        }
        return false;
    }
}
