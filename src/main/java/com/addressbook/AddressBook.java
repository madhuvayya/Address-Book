package com.addressbook;

import java.util.*;
import java.util.stream.Collectors;

public class AddressBook {

    List<Person> personsList = new ArrayList<>();
    FileOperations fileOperations = new FileOperations();

    enum CompareBy{
        FIRST_NAME,
        ZIP
    }

    public void add(String addressBookName,String firstName, String lastName, String address, String city, String state, String zip,
                    String phoneNumber) {
        if(firstName == "" || lastName == "" || address == "" || city == "" || state == ""|| zip == "" ||
                phoneNumber == "")
            throw new AddressBookException(AddressBookException.ExceptionType.ENTERED_EMPTY,"Entered Empty");
        int index = this.getIndex(phoneNumber);
        if(index != -1)
            throw new AddressBookException(AddressBookException.ExceptionType.EXISTING,"Entered already existing data");
        Person person = new Person(firstName, lastName, address, city, state, zip, phoneNumber);
        if(!this.search(addressBookName,phoneNumber)) {
            personsList.add(person);
            fileOperations.writeInFile(addressBookName,personsList);
        }
    }

    public boolean search(String addressBookName,String phoneNumber) {
        if(!fileOperations.isEmpty(addressBookName)) {
            personsList = fileOperations.loadDataFromFile(addressBookName);
            for (Person person : personsList) {
                if (person.phoneNumber.equals(phoneNumber))
                    return true;
            }
        }
        return false;
    }

    private int getIndex(String phoneNumber) {
        for (int index = 0; index< personsList.size(); index++) {
            String firstName = personsList.get(index).phoneNumber;
            if (firstName.equals(phoneNumber))
                return index;
        }
        return -1;
    }

    public void edit(String addressBookName,String oldPhoneNumber,String address,String city,String state,String zip,String newPhoneNumber) {
        if(oldPhoneNumber == "" || address == "" || city == "" || state == ""|| zip == "" || newPhoneNumber == "")
            throw new AddressBookException(AddressBookException.ExceptionType.ENTERED_EMPTY,"Entered Empty");
        personsList = fileOperations.loadDataFromFile(addressBookName);
        int index = this.getIndex(oldPhoneNumber);
        if(index == -1)
            throw new AddressBookException(AddressBookException.ExceptionType.NOT_EXISTING,"Not existing data");
        personsList.get(index).setAddress(address);
        personsList.get(index).setCity(city);
        personsList.get(index).setState(state);
        personsList.get(index).setZip(zip);
        personsList.get(index).setPhoneNumber(newPhoneNumber);
        fileOperations.writeInFile(addressBookName,personsList);
    }

    public void delete(String addressBookName,String phoneNumber) {
        if(addressBookName == "" ||  phoneNumber == "")
            throw new AddressBookException(AddressBookException.ExceptionType.ENTERED_EMPTY,"entered empty");
        personsList = fileOperations.loadDataFromFile(addressBookName);
        int index = this.getIndex(phoneNumber);
        if(index == -1)
            throw new AddressBookException(AddressBookException.ExceptionType.NOT_EXISTING,"Data not existing");
        personsList.remove(index);
        fileOperations.writeInFile(addressBookName,personsList);
    }

    public List<Person> sortPersonData(Comparator<Person> comparator,String addressBookName) {
        personsList = fileOperations.loadDataFromFile(addressBookName);
        return personsList.stream()
                .sorted(comparator)
                .collect(Collectors.toList());
    }

    public void print(String addressBookName) {
        if(fileOperations.isEmpty(addressBookName))
            throw new AddressBookException(AddressBookException.ExceptionType.BOOK_IS_EMPTY,"Book is empty");
        personsList = fileOperations.loadDataFromFile(addressBookName);
        for (Person person: personsList) {
            System.out.println(person);
        }
    }
}
