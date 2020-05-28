package com.addressbook;

import java.util.ArrayList;
import java.util.List;

public class AddressBook {

    List<Person> addressBook = new ArrayList<Person>();

    public void add(String firstName, String lastName, String address, String city, String state, String zip,
                    String phone) {
        if(firstName == "" || lastName == "" || address == "" || city == "" || state == ""|| zip == "" ||
                phone == "")
            throw new AddressBookException(AddressBookException.ExceptionType.ENTERED_EMPTY,"Entered Empty");
        Person person = new Person(firstName, lastName, address, city, state, zip, phone);
        addressBook.add(person);
    }


    public boolean search(String searchedFirstName) {
        for (Person person : addressBook) {
            String name = person.firstName;
            if (name.equals(searchedFirstName))
                return true;
        }
        return false;
    }

    public int getIndex(String searchedName) {
        for (int i = 0; i< addressBook.size(); i++) {
            String firstName = addressBook.get(i).firstName;
            if (firstName.equals(searchedName))
                return i;
        }
        return -1;
    }
}
