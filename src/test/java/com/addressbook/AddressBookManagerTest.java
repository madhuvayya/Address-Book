package com.addressbook;

import org.junit.Assert;
import org.junit.Test;
import sun.security.provider.AuthPolicyFile;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class AddressBookManagerTest {

    AddressBookManager addressBookManager = new AddressBookManager();
    AddressBook addressBook = new AddressBook();

    @Test
    public void givenAddressBookName_whenCreated_shouldCreateNewAddressBook() {
        addressBookManager.createNewBook("AddressBook1");
        try ( Reader reader = Files.newBufferedReader(Paths.get("./src/main/resources/AddressBook1.json"))) {
            addressBook.add("AddressBook1","ramesh","k","ram nagar","hyderabad","Telangana",
                    "456132","1111111111");
        } catch (IOException e){
            throw new AddressBookException(AddressBookException.ExceptionType.FILE_NOT_CREATED,"file is not created");
        }
    }

    @Test
    public void givenAddressBookName_whenNotExisting_shouldThrowException() {
        try {
            addressBookManager.open("");
        } catch (AddressBookException e){
            Assert.assertEquals(AddressBookException.ExceptionType.ENTERED_EMPTY,e.type);
        }
    }
}
