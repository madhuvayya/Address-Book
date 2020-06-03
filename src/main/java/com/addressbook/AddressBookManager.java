package com.addressbook;

import java.io.File;
import java.io.IOException;

public class AddressBookManager {

    FileOperations fileOperations;
    AddressBook addressBook;

    public AddressBookManager() {
        this.fileOperations = new FileOperations();
    }

    public void createNewBook(String addressBookName){
        this.checkEnteredEmptyFields(addressBookName);
        fileOperations.createFile(addressBookName);
        String filePath = "./src/main/resources/"+addressBookName+".json";
        File newFile = new File(filePath);
        boolean isCreated = false;
        try {
            isCreated = newFile.createNewFile();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    public void addPersonDetails(String addressBookName,String firstName, String lastName, String address, String city,
                                 String state, String zip, String phoneNumber){
        this.checkEnteredEmptyFields(addressBookName, firstName, lastName, address, city, state, zip,
                                        phoneNumber);
        addressBook.add(addressBookName,firstName, lastName,
                address, city, state, zip, phoneNumber);
    }

    public void deleteAddressBook(String addressBook){
        this.checkEnteredEmptyFields(addressBook);
        fileOperations.deleteFile(addressBook);
    }

    public void deletePersonDetails(String addressBookName,String phoneNumber){
        this.checkEnteredEmptyFields(addressBookName,phoneNumber);
        addressBook.delete(addressBookName,phoneNumber);
    }

    public int loadAddressBooks(){
        return fileOperations.loadFiles();
    }

    public void printBookEntries(String addressBookName){
        this.checkEnteredEmptyFields(addressBookName);
        addressBook.print(addressBookName);
    }

    public void saveAs(String bookName,String newBookName) throws AddressBookException{
        this.checkEnteredEmptyFields(bookName,newBookName);
        fileOperations.copy(bookName,newBookName);
    }

    private void checkEnteredEmptyFields(String ...fields){
        for(String field: fields){
            if(field.equals(""))
                throw new AddressBookException(AddressBookException.ExceptionType.ENTERED_EMPTY,"Entered Empty");
        }
    }
}
