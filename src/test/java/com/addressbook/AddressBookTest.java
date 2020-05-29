package com.addressbook;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

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
    public void givenPersonDetailsWithAllEmptyFields_whenPassedToAddMethod_shouldThrowException() {
        try {
            addressBook.add("", "", "", "", "",
                    "", "");
        } catch (AddressBookException e){
            Assert.assertEquals(AddressBookException.ExceptionType.ENTERED_EMPTY,e.type);
        }
    }

    @Test
    public void givenPersonDetailsWithOneEmptyField_whenPassedToAddMethod_shouldThrowException() {
        try {
            addressBook.add("", "k", "ram nagar", "hyderabad", "Telangana",
                    "536872", "9999999999");
        } catch (AddressBookException e){
            Assert.assertEquals(AddressBookException.ExceptionType.ENTERED_EMPTY,e.type);
        }
    }

    @Test
    public void givenPersonDetails_whenSameMobileNumberGivenByOtherPerson_shouldThrowAnException() {
        addressBook.add("ramesh","c","ram nagar","hyderabad","Telangana",
                "456132","1111111111");
        addressBook.add("suresh","k","NTR nagar","vijayawada","Andra pradhesh",
                "512631","7777777777");
        try {
            addressBook.add("mahesh", "e", "ram nagar", "hyderabad", "Telangana",
                    "536872", "1111111111");
        } catch (AddressBookException e){
            Assert.assertEquals(AddressBookException.ExceptionType.EXISTING,e.type);
        }
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
        boolean result = addressBook.search("5555555555");
        Assert.assertTrue(result);
    }

    @Test
    public void givenPersonsDetailsAndSearched_whenNotFound_shouldReturnFalse() {
        addressBook.add("rajesh","k","ram nagar","hyderabad","Telangana",
                "456132","1111111111");
        addressBook.add("ramesh","Nj","prakash nagar","hyderabad","Telangana",
                "6456221","2222222222");
        boolean result = addressBook.search("3333333333");
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
        int result = addressBook.getIndex("1111111111");
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
        int result = addressBook.getIndex("7777777777");
        Assert.assertNotEquals(1,result);
    }


    @Test
    public void givenPersonsDetails_whenSearchedForPersonDataNotExisting_shouldReturnNegativeValue() {
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
    public void givenPersonsDetailsAndEditSomeDetails_whenDetailsEdited_shouldReturnEditedValues() {
        addressBook.add("ramesh","k","ram nagar","hyderabad","Telangana",
                "536872","9999999999");
        addressBook.add("rajesh","mn","subhash nagar","hyderabad","Telangana",
                "513867","1111111111");
        addressBook.add("naresh","d","Nizampet","hyderabad","Telangana",
                "512365","8888888888");
        addressBook.edit("1111111111","Nizampet","Secunderabad","Telangana","523648",
                "7777777777");
        String address = addressBook.addressBook.get(1).getAddress();
        Assert.assertEquals("Nizampet",address);
        int result = addressBook.getIndex("7777777777");
        Assert.assertEquals(1,result);
    }

    @Test
    public void givenPersonsDetailsAndEditSomeDetails_whenDetailsEdited_shouldNotReturnPastValues() {
        addressBook.add("ramesh","k","ram nagar","hyderabad","Telangana",
                "536872","9999999999");
        addressBook.add("rajesh","mn","subhash nagar","hyderabad","Telangana",
                "513867","1111111111");
        addressBook.add("naresh","d","Nizampet","hyderabad","Telangana",
                "512365","8888888888");
        addressBook.edit("1111111111","Nizampet","Secunderabad","Telangana","523648",
                "7777777777");
        String city = addressBook.addressBook.get(1).getCity();
        Assert.assertNotEquals("hyderabad",city);
    }

    @Test
    public void givenPersonsDetails_whenDeleted_shouldReturnNegativeIndexValue() {
        addressBook.add("ramesh","k","ram nagar","hyderabad","Telangana",
                "536872","9999999999");
        addressBook.add("rajesh","mn","subhash nagar","hyderabad","Telangana",
                "513867","1111111111");
        addressBook.add("naresh","d","Nizampet","hyderabad","Telangana",
                "512365","8888888888");
        addressBook.delete("9999999999");
        boolean result = addressBook.search("9999999999");
        Assert.assertFalse(result);
    }

    @Test
    public void givenPersonsDetails_whenSortedByFirstName_shouldReturnDataInSortedOrder() {
        addressBook.add("ramesh","k","ram nagar","hyderabad","Telangana",
                "536872","9999999999");
        addressBook.add("rajesh","mn","subhash nagar","hyderabad","Telangana",
                "513867","1111111111");
        addressBook.add("naresh","d","Nizampet","hyderabad","Telangana",
                "512365","8888888888");
        List<Person> sortPersonDataAccordingToFirstName = addressBook.sortPersonData(new Comparators()
                .getComparator(AddressBook.CompareBy.FIRST_NAME));
        Assert.assertEquals("naresh", sortPersonDataAccordingToFirstName.get(0).firstName);
    }

    @Test
    public void givenPersonsDetails_whenSortedByZip_shouldReturnDataInSortedOrder() {
        addressBook.add("ramesh","k","ram nagar","hyderabad","Telangana",
                "536872","9999999999");
        addressBook.add("rajesh","mn","subhash nagar","hyderabad","Telangana",
                "513867","1111111111");
        addressBook.add("naresh","d","Nizampet","hyderabad","Telangana",
                "512365","8888888888");
        List<Person> sortPersonDataAccordingToZip = addressBook.sortPersonData(new Comparators()
                .getComparator(AddressBook.CompareBy.ZIP));
        Assert.assertEquals("536872", sortPersonDataAccordingToZip.get(2).zip);
    }

    @Test
    public void givenPersonsDetails_whenPrintMethodInvoked_shouldPrintDetails() {
        addressBook.add("ramesh","k","ram nagar","hyderabad","Telangana",
                "536872","9999999999");
        addressBook.add("rajesh","mn","subhash nagar","hyderabad","Telangana",
                "513867","1111111111");
        addressBook.add("naresh","d","Nizampet","hyderabad","Telangana",
                "512365","8888888888");
        addressBook.print();
    }

}
