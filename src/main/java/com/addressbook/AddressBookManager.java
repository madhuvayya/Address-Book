package com.addressbook;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AddressBookManager {

    FileOperations fileOperations;
    AddressBook addressBook;
    Map<String,AddressBook> addressBooks;
    List<AddressBook> addressBookList;

    public AddressBookManager() {
        this.fileOperations = new FileOperations();
        this.addressBooks = new HashMap<>();
    }

    public void createNewBook(String addressBookName){
        String filePath = "./src/main/resources/"+addressBookName+".json";
        File newFile = new File(filePath);
        boolean isCreated = false;
        try {
            isCreated = newFile.createNewFile();
            addressBooks.put(addressBookName,new AddressBook());
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    public void deleteAddressBook(String addressBook){
        fileOperations.deleteFile(addressBook);
    }

    public int loadAddressBooks(){
        return fileOperations.loadFiles();
    }

    public void printBookEntries(String addressBookName){
        addressBook.print(addressBookName);
    }
}
