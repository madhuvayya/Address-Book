package com.addressbook;

import org.junit.Assert;
import org.junit.Test;

public class AddressBookManagerTest {

    AddressBookManager addressBookManager = new AddressBookManager();

    @Test
    public void givenAddressBookName_whenNotExisting_shouldCreateNewFile() {
        try {
            addressBookManager.createNewBook("AddressBook1");
        } catch (AddressBookException e){
            Assert.assertEquals(AddressBookException.ExceptionType.EXISTING,e.type);
        }
    }

    @Test
    public void givenAddressBookName_whenExisting_shouldThrowException() {
        try {
            addressBookManager.createNewBook("AddressBook2");
        } catch (AddressBookException e){
            Assert.assertEquals(AddressBookException.ExceptionType.EXISTING,e.type);
        }
    }
}
