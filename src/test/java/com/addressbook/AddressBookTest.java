package com.addressbook;

import org.junit.Assert;
import org.junit.Test;

public class AddressBookTest {

    @Test
    public void givenPersonsDetails_whenAddedToList_shouldReturnCorrectList() {
        AddressBook addressBook = new AddressBook();
        addressBook.add("ramesh","k","ram nagar","hyderabad","Telangana",
                "456132","1111111111");
        int size = addressBook.addressBookList.size();
        Assert.assertEquals(1,size);
    }

    @Test
    public void givenPersonsDetails_whenAddedToList_shouldReturnAddedSize() {
        AddressBook addressBook = new AddressBook();
        addressBook.add("ramesh","k","ram nagar","hyderabad","Telangana",
                "456132","1111111111");
        addressBook.add("rakesh","n","pvp colony","hyderabad","Telangana",
                "456132","1111111111");
        int size = addressBook.addressBookList.size();
        Assert.assertEquals(2,size);
    }

    @Test
    public void removedPersonDetails_whenRemovedFromList_shouldReturnAddedSize() {
        AddressBook addressBook = new AddressBook();
        addressBook.add("ramesh","k","ram nagar","hyderabad","Telangana",
                "456132","1111111111");
        addressBook.add("ramesh","k","ram nagar","hyderabad","Telangana",
                "456132","1111111111");
        addressBook.addressBookList.remove(1);
        int size = addressBook.addressBookList.size();
        Assert.assertNotEquals(2,size);
    }

    @Test
    public void givenPersonsDetailsAndSearched_whenFound_shouldReturnTrue() {
        AddressBook addressBook = new AddressBook();
        addressBook.add("ramesh","k","ram nagar","hyderabad","Telangana",
                "456132","1111111111");
        addressBook.add("ramesh","k","ram nagar","hyderabad","Telangana",
                "456132","1111111111");
        boolean result = addressBook.search("ramesh");
        Assert.assertTrue(result);
    }

    @Test
    public void givenPersonsDetailsAndSearched_whenNotFound_shouldReturnFalse() {
        AddressBook addressBook = new AddressBook();
        addressBook.add("ramesh","k","ram nagar","hyderabad","Telangana",
                "456132","1111111111");
        addressBook.add("ramesh","k","ram nagar","hyderabad","Telangana",
                "456132","1111111111");
        boolean result = addressBook.search("mahesh");
        Assert.assertFalse(result);
    }
}
