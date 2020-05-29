package com.addressbook;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AddressBookManager {

    List<AddressBook> addressBookList = new ArrayList<>();

    public void createNewBook(String addressBookName){
        if(addressBookName == "")
            throw new AddressBookException(AddressBookException.ExceptionType.ENTERED_EMPTY,"Entered empty");
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String filePath = "./src/test/resources/"+addressBookName+".json";

        FileWriter writer = null;
        try {
            writer = new FileWriter(filePath);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
