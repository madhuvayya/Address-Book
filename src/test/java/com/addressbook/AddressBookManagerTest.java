package com.addressbook;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class AddressBookManagerTest {

    AddressBookManager addressBookManager = new AddressBookManager();

    @Test
    public void givenAddressBookName_whenCreated_shouldCreateNewAddressBook() {
        addressBookManager.createNewBook("AddressBook1");
        try ( Reader reader = Files.newBufferedReader(Paths.get("./src/test/resources/AddressBook1.json"))) {
        } catch (IOException e){
            throw new AddressBookException(AddressBookException.ExceptionType.FILE_NOT_CREATED,"file is not created");
        }
    }
}
