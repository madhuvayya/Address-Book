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


    public boolean search(String searchedFirstName) {
        for (Person person : addressBookList) {
            String name = person.firstName;
            if (name.equals(searchedFirstName))
                return true;
        }
        return false;
    }

    public int getIndex(String searchedName) {
        for (int i=0;i<addressBookList.size();i++) {
            String firstName = addressBookList.get(i).firstName;
            if (firstName.equals(searchedName))
                return i;
        }
        return -1;
    }
}
