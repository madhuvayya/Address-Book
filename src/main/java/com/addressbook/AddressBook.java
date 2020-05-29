package com.addressbook;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class AddressBook {

    List<Person> addressBook = new ArrayList<>();

    Comparator<Person> comparator = Comparator.comparing(person -> person.firstName);

    public void add(String firstName, String lastName, String address, String city, String state, String zip,
                    String phoneNumber) {
        if(firstName == "" || lastName == "" || address == "" || city == "" || state == ""|| zip == "" ||
                phoneNumber == "")
            throw new AddressBookException(AddressBookException.ExceptionType.ENTERED_EMPTY,"Entered Empty");
        int index = this.getIndex(phoneNumber);
        if(index != -1)
            throw new AddressBookException(AddressBookException.ExceptionType.EXISTING,"Entered already existing data");
        Person person = new Person(firstName, lastName, address, city, state, zip, phoneNumber);
        addressBook.add(person);
    }

    public boolean search(String phoneNumber) {
        for (Person person : addressBook) {
            String name = person.phoneNumber;
            if (name.equals(phoneNumber))
                return true;
        }
        return false;
    }

    public int getIndex(String phoneNumber) {
        for (int i = 0; i< addressBook.size(); i++) {
            String firstName = addressBook.get(i).phoneNumber;
            if (firstName.equals(phoneNumber))
                return i;
        }
        return -1;
    }

    public void edit(String oldPhoneNumber,String address,String city,String state,String zip,String newPhoneNumber) {
        if(oldPhoneNumber == "" || address == "" || city == "" || state == ""|| zip == "" || newPhoneNumber == "")
            throw new AddressBookException(AddressBookException.ExceptionType.ENTERED_EMPTY,"Entered Empty");
        int index = this.getIndex(oldPhoneNumber);
        if(index == -1)
            throw new AddressBookException(AddressBookException.ExceptionType.NOT_EXISTING,"Not existing data");
        addressBook.get(index).setAddress(address);
        addressBook.get(index).setCity(city);
        addressBook.get(index).setState(state);
        addressBook.get(index).setZip(zip);
        addressBook.get(index).setPhoneNumber(newPhoneNumber);
    }

    public void delete(String phoneNumber) {
        if(phoneNumber == "")
            throw new AddressBookException(AddressBookException.ExceptionType.ENTERED_EMPTY,"entered empty");
        int index = this.getIndex(phoneNumber);
        if(index == -1)
            throw new AddressBookException(AddressBookException.ExceptionType.NOT_EXISTING,"Data not existing");
        addressBook.remove(index);
    }

    public List<Person> sortPersonData() {
        List<Person> sortedAddressBookData = addressBook.stream()
                .sorted(comparator)
                .collect(Collectors.toList());
        return sortedAddressBookData;
    }
}
