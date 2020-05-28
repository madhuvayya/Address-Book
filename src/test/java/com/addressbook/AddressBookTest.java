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
                "461164","8888888888");
        int size = addressBook.addressBookList.size();
        Assert.assertEquals(2,size);
    }

    @Test
    public void removedPersonDetails_whenRemovedFromList_shouldReturnAddedSize() {
        AddressBook addressBook = new AddressBook();
        addressBook.add("ramesh","c","ram nagar","hyderabad","Telangana",
                "456132","1111111111");
        addressBook.add("suresh","k","NTR nagar","vijayawada","Andra pradhesh",
                "512631","7777777777");
        addressBook.addressBookList.remove(1);
        int size = addressBook.addressBookList.size();
        Assert.assertNotEquals(2,size);
    }

    @Test
    public void givenPersonsDetailsAndSearched_whenFound_shouldReturnTrue() {
        AddressBook addressBook = new AddressBook();
        addressBook.add("naresh","k","ram nagar","hyderabad","Telangana",
                "456132","1111111111");
        addressBook.add("ramesh","m","kalyan nagar","chennai","Tamilnadu",
                "513712","5555555555");
        boolean result = addressBook.search("ramesh");
        Assert.assertTrue(result);
    }

    @Test
    public void givenPersonsDetailsAndSearched_whenNotFound_shouldReturnFalse() {
        AddressBook addressBook = new AddressBook();
        addressBook.add("rajesh","k","ram nagar","hyderabad","Telangana",
                "456132","1111111111");
        addressBook.add("ramesh","Nj","prakash nagar","hyderabad","Telangana",
                "6456221","2222222222");
        boolean result = addressBook.search("mahesh");
        Assert.assertFalse(result);
    }

    @Test
    public void givenPersonsDetailsAndIndexValueSearched_whenIndexValueFound_shouldReturnIndex() {
        AddressBook addressBook = new AddressBook();
        addressBook.add("ramesh","k","ram nagar","hyderabad","Telangana",
                "536872","9999999999");
        addressBook.add("rajesh","mn","subhash nagar","hyderabad","Telangana",
                "513867","1111111111");
        addressBook.add("naresh","d","Nizampet","hyderabad","Telangana",
                "512365","8888888888");
        int result = addressBook.getIndex("rajesh");
        Assert.assertEquals(1,result);
    }

    @Test
    public void givenPersonsDetailsAndIndexValueSearched_whenIndexNotFound_shouldReturnNegative() {
        AddressBook addressBook = new AddressBook();
        addressBook.add("ramesh","k","ram nagar","hyderabad","Telangana",
                "536872","9999999999");
        addressBook.add("rajesh","mn","subhash nagar","hyderabad","Telangana",
                "513867","1111111111");
        addressBook.add("naresh","d","Nizampet","hyderabad","Telangana",
                "512365","8888888888");
        int result = addressBook.getIndex("Jayanth");
        Assert.assertNotEquals(1,result);
    }
}
