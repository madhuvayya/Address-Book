package com.addressbook;

import java.io.File;

public class AddressBookManager {

    FileOperations fileOperations = new FileOperations();

    public void createNewBook(String addressBookName){
        if(fileOperations.getFileStatus(addressBookName))
            throw new AddressBookException(AddressBookException.ExceptionType.FILE_EXISTS,"File Exists");
        fileOperations.createFile(addressBookName);
    }

    public void open(String fileName) {
        if(fileName == "")
            throw new AddressBookException(AddressBookException.ExceptionType.ENTERED_EMPTY,"Entered empty");
        if(new File(fileName).exists())
            throw new AddressBookException(AddressBookException.ExceptionType.NOT_EXISTING,"File not exists");
    }


}
