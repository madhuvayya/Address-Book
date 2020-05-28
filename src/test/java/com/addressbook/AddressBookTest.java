package com.addressbook;

import org.junit.Assert;
import org.junit.Test;

public class AddressBookTest {
    AddressBook addressBook = new AddressBook();

    @Test
    public void givenPersonsDetails_whenAddedToList_shouldReturnCorrectList() {
        addressBook.add("ramesh","k","ram nagar","hyderabad","Telangana",
                "456132","1111111111");
        int size = addressBook.addressBook.size();
        Assert.assertEquals(1,size);
    }

    @Test
    public void givenPersonsDetails_whenAddedToList_shouldReturnAddedSize() {
        addressBook.add("ramesh","k","ram nagar","hyderabad","Telangana",
                "456132","1111111111");
        addressBook.add("rakesh","n","pvp colony","hyderabad","Telangana",
                "461164","8888888888");
        int size = addressBook.addressBook.size();
        Assert.assertEquals(2,size);
    }

    @Test
    public void removedPersonDetails_whenRemovedFromList_shouldReturnAddedSize() {
        addressBook.add("ramesh","c","ram nagar","hyderabad","Telangana",
                "456132","1111111111");
        addressBook.add("suresh","k","NTR nagar","vijayawada","Andra pradhesh",
                "512631","7777777777");
        addressBook.addressBook.remove(1);
        int size = addressBook.addressBook.size();
        Assert.assertNotEquals(2,size);
    }

    @Test
    public void givenPersonsDetailsAndSearched_whenFound_shouldReturnTrue() {
        addressBook.add("naresh","k","ram nagar","hyderabad","Telangana",
                "456132","1111111111");
        addressBook.add("ramesh","m","kalyan nagar","chennai","Tamilnadu",
                "513712","5555555555");
        boolean result = addressBook.search("ramesh");
        Assert.assertTrue(result);
    }

    @Test
    public void givenPersonsDetailsAndSearched_whenNotFound_shouldReturnFalse() {
        addressBook.add("rajesh","k","ram nagar","hyderabad","Telangana",
                "456132","1111111111");
        addressBook.add("ramesh","Nj","prakash nagar","hyderabad","Telangana",
                "6456221","2222222222");
        boolean result = addressBook.search("mahesh");
        Assert.assertFalse(result);
    }

    @Test
    public void givenPersonsDetailsAndIndexValueSearched_whenIndexValueFound_shouldReturnIndex() {
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
        addressBook.add("ramesh","k","ram nagar","hyderabad","Telangana",
                "536872","9999999999");
        addressBook.add("rajesh","mn","subhash nagar","hyderabad","Telangana",
                "513867","1111111111");
        addressBook.add("naresh","d","Nizampet","hyderabad","Telangana",
                "512365","8888888888");
        int result = addressBook.getIndex("Jayanth");
        Assert.assertNotEquals(1,result);
    }


    @Test
    public void givenPersonsDetails_whenSearchedForPersonDetNotAdded_shouldReturnEditedValues() {
        addressBook.add("ramesh","k","ram nagar","hyderabad","Telangana",
                "536872","9999999999");
        addressBook.add("rajesh","mn","subhash nagar","hyderabad","Telangana",
                "513867","1111111111");
        addressBook.add("naresh","d","Nizampet","hyderabad","Telangana",
                "512365","8888888888");
        int result = addressBook.getIndex("suresh");
        Assert.assertEquals(-1,result);
    }

    @Test
    public void givenPersonDetailsWithOneEmptyField_whenPassedToAddMethod_shouldReturnException() {
        try {
            addressBook.add("", "k", "ram nagar", "hyderabad", "Telangana",
                    "536872", "9999999999");
        } catch (AddressBookException e){
            Assert.assertEquals(AddressBookException.ExceptionType.ENTERED_EMPTY,e.type);
        }
    }

    @Test
    public void givenPersonDetailsWithAllEmptyFields_whenPassedToAddMethod_shouldReturnException() {
        try {
            addressBook.add("", "", "", "", "",
                    "", "");
        } catch (AddressBookException e){
            Assert.assertEquals(AddressBookException.ExceptionType.ENTERED_EMPTY,e.type);
        }
    }
}