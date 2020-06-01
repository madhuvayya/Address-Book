package com.addressbook;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AddressBookManager {

    FileOperations fileOperations;
    AddressBook addressBook;
    Map<String,AddressBook> addressBooks;

    public AddressBookManager() {
        this.fileOperations = new FileOperations();
        this.addressBooks = new HashMap<>();
    }

    public void createNewBook(String addressBookName){
        String filePath = "./src/main/resources/"+addressBookName+".json";
        File newFile = new File(filePath);
        boolean isCreated = false;
        try {
            isCreated = newFile.createNewFile();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    public void open(String fileName) {
        List personList = fileOperations.loadDataFromFile(fileName);
    }

    public void add(String addressBookName,String firstName, String lastName, String address, String city, String state,
                    String zip, String mobileNumber) throws AddressBookException {
        addressBooks.get(addressBook).add(addressBookName,firstName,lastName,address,city,state,zip,mobileNumber);
    }
}
