package com.addressbook;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class AddressBookTest {
    AddressBook addressBook = new AddressBook();

    @Test
    public void givenPersonsDetails_whenAddedToList_shouldReturnCorrectList() {
        addressBook.add("AddressBook1","ramesh","k","ram nagar","hyderabad","Telangana",
                "456132","1111111111");
        int size = addressBook.personsList.size();
        Assert.assertEquals(1,size);
    }

    @Test
    public void givenPersonsDetails_whenAddedToList_shouldReturnAddedSize() {
        addressBook.add("AddressBook1","ramesh","k","ram nagar","hyderabad","Telangana",
                "456132","1111111111");
        addressBook.add("AddressBook1","rakesh","n","pvp colony","hyderabad","Telangana",
                "461164","8888888888");
        int size = addressBook.personsList.size();
        Assert.assertEquals(2,size);
    }

    @Test
    public void givenPersonDetailsWithAllEmptyFields_whenPassedToAddMethod_shouldThrowException() {
        try {
            addressBook.add("AddressBook1","", "", "", "", "",
                    "", "");
        } catch (AddressBookException e){
            Assert.assertEquals(AddressBookException.ExceptionType.ENTERED_EMPTY,e.type);
        }
    }

    @Test
    public void givenPersonDetailsWithOneEmptyField_whenPassedToAddMethod_shouldThrowException() {
        try {
            addressBook.add("AddressBook1","" ,"k", "ram nagar", "hyderabad", "Telangana",
                    "536872", "9999999999");
        } catch (AddressBookException e){
            Assert.assertEquals(AddressBookException.ExceptionType.ENTERED_EMPTY,e.type);
        }
    }

    @Test
    public void givenPersonDetails_whenSameMobileNumberGivenByOtherPerson_shouldThrowAnException() {
        addressBook.add("AddressBook1","ramesh","c","ram nagar","hyderabad","Telangana",
                "456132","1111111111");
        addressBook.add("AddressBook1","suresh","k","NTR nagar","vijayawada","Andra pradhesh",
                "512631","7777777777");
        try {
            addressBook.add("AddressBook1","mahesh", "e", "ram nagar", "hyderabad", "Telangana",
                    "536872", "1111111111");
        } catch (AddressBookException e){
            Assert.assertEquals(AddressBookException.ExceptionType.EXISTING,e.type);
        }
    }

    @Test
    public void removedPersonDetails_whenRemovedFromList_shouldReturnAddedSize() {
        try {
            addressBook.delete("AddressBook1", "1111111111");
        }catch (AddressBookException e){
            Assert.assertEquals(AddressBookException.ExceptionType.NOT_EXISTING,e.type);
        }
    }

    @Test
    public void givenPersonsDetailsAndSearched_whenFound_shouldReturnTrue() {
        boolean result = addressBook.search("AddressBook1","5555555555");
        Assert.assertTrue(result);
    }

    @Test
    public void givenPersonsDetailsAndSearched_whenNotFound_shouldReturnFalse() {
        boolean result = addressBook.search("AddressBook1","3333333333");
        Assert.assertFalse(result);
    }

    @Test
    public void givenPersonsDetails_whenSortedByFirstName_shouldReturnDataInSortedOrder() {
        List<Person> sortPersonDataAccordingToFirstName = addressBook.sortPersonData(new Comparators()
                .getComparator(AddressBook.CompareBy.FIRST_NAME),"AddressBook1");
        Assert.assertEquals("naresh", sortPersonDataAccordingToFirstName.get(0).firstName);
    }

    @Test
    public void givenPersonsDetails_whenSortedByZip_shouldReturnDataInSortedOrder() {
        List<Person> sortPersonDataAccordingToZip = addressBook.sortPersonData(new Comparators()
                .getComparator(AddressBook.CompareBy.ZIP),"AddressBook1");
        Assert.assertEquals("456132", sortPersonDataAccordingToZip.get(0).zip);
    }

    @Test
    public void givenPersonsDetails_whenPrintMethodInvoked_shouldPrintDetails() {
        addressBook.print("AddressBook1");
    }

    @Test
    public void editedPersonDetails_whenEdited_shouldReturnModifiedPersonDetails() {
        try {
            addressBook.edit("AddressBook1","5555555555","ram nagar" ,"hyderabad", "Telangana",
                    "536872", "9999999999");
        } catch (AddressBookException e){
            Assert.assertEquals(AddressBookException.ExceptionType.NOT_EXISTING,e.type);
        }
    }
}
