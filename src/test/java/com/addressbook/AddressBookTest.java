package com.addressbook;

import org.junit.Assert;
import org.junit.Test;

public class AddressBookTest {

    @Test
    public void givenPersonDetails_whenAddedToList_shouldReturnCorrectList() {
        AddressBook addressBook = new AddressBook();
        addressBook.add("ramesh","k","ram nagar","hyderabad","Telangana",
                "456132","1111111111");
        int size = addressBook.addressBookList.size();
        Assert.assertEquals(1,size);
    }

    @Test
    public void givenPersonDetails_whenAddedToList_shouldReturnAddedSize() {
        AddressBook addressBook = new AddressBook();
        addressBook.add("ramesh","k","ram nagar","hyderabad","Telangana",
                "456132","1111111111");
        addressBook.add("rakesh","n","pvp colony","hyderabad","Telangana",
                "456132","1111111111");
        int size = addressBook.addressBookList.size();
        Assert.assertEquals(2,size);
    }

    @Test
    public void removdPersonDetails_whenAddedToList_shouldReturnAddedSize() {
        AddressBook addressBook = new AddressBook();
        addressBook.add("ramesh","k","ram nagar","hyderabad","Telangana",
                "456132","1111111111");
        addressBook.add("ramesh","k","ram nagar","hyderabad","Telangana",
                "456132","1111111111");
        addressBook.addressBookList.remove(1);
        int size = addressBook.addressBookList.size();
        Assert.assertNotEquals(2,size);
    }
}
