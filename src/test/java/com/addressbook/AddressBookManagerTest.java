package com.addressbook;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

@RunWith(MockitoJUnitRunner.class)
public class AddressBookManagerTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Mock
    public FileOperations fileOperations;

    @InjectMocks
    public AddressBookManager addressBookManager;

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
            addressBookManager.createNewBook("AddressBook1");
        } catch (AddressBookException e){
            Assert.assertEquals(AddressBookException.ExceptionType.EXISTING,e.type);
        }
    }

    @Test
    public void invokedLoadAddressBooks_whenLoaded_shouldReturnNumberOfFiles() {
        Mockito.when(fileOperations.loadFiles()).thenReturn(2);
        int numberOfBooks = addressBookManager.loadAddressBooks();
        Assert.assertEquals(2,numberOfBooks);
    }
}
