package com.addressbook;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class AddressBook {

    enum CompareBy{
        FIRST_NAME,
        ZIP
    }

    List<Person> personsList = new ArrayList<>();

    public void add(String firstName, String lastName, String address, String city, String state, String zip,
                    String phoneNumber) {
        if(firstName == "" || lastName == "" || address == "" || city == "" || state == ""|| zip == "" ||
                phoneNumber == "")
            throw new AddressBookException(AddressBookException.ExceptionType.ENTERED_EMPTY,"Entered Empty");
        int index = this.getIndex(phoneNumber);
        if(index != -1)
            throw new AddressBookException(AddressBookException.ExceptionType.EXISTING,"Entered already existing data");
        Person person = new Person(firstName, lastName, address, city, state, zip, phoneNumber);
        personsList.add(person);
    }

    public boolean search(String phoneNumber) {
        for (Person person : personsList) {
            String name = person.phoneNumber;
            if (name.equals(phoneNumber))
                return true;
        }
        return false;
    }

    public int getIndex(String phoneNumber) {
        for (int i = 0; i< personsList.size(); i++) {
            String firstName = personsList.get(i).phoneNumber;
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
        personsList.get(index).setAddress(address);
        personsList.get(index).setCity(city);
        personsList.get(index).setState(state);
        personsList.get(index).setZip(zip);
        personsList.get(index).setPhoneNumber(newPhoneNumber);
    }

    public void delete(String phoneNumber) {
        if(phoneNumber == "")
            throw new AddressBookException(AddressBookException.ExceptionType.ENTERED_EMPTY,"entered empty");
        int index = this.getIndex(phoneNumber);
        if(index == -1)
            throw new AddressBookException(AddressBookException.ExceptionType.NOT_EXISTING,"Data not existing");
        personsList.remove(index);
    }

    public List<Person> sortPersonData(Comparator<Person> comparator) {
        return personsList.stream()
                .sorted(comparator)
                .collect(Collectors.toList());
    }

    public void print() {
        if(personsList.size() == 0)
            throw new AddressBookException(AddressBookException.ExceptionType.BOOK_IS_EMPTY,"Book is empty");
        for (Person person: personsList) {
            person.toString();
        }
    }
}
