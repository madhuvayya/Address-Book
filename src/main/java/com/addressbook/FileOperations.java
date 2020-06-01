package com.addressbook;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileOperations {

    public String getFilePath(String fileName) throws AddressBookException {
        try {
            if (fileName.equals(""))
                throw new AddressBookException( AddressBookException.ExceptionType.ENTERED_EMPTY,"Entered Empty");
                return  "./src/main/resources/"+fileName+".json";
        } catch (NullPointerException  e) {
            throw new AddressBookException(AddressBookException.ExceptionType.ENTERED_NULL,"Entered Null");
        }
    }

    public boolean isItExist(String fileName) throws AddressBookException {
        String filePath = this.getFilePath(fileName);
        return new File(filePath).exists();
    }

    public List<Person> loadDataFromFile(String fileName) throws AddressBookException {
        List<Person> data = new ArrayList<>();
        if (fileName.equals(""))
            throw new AddressBookException( AddressBookException.ExceptionType.ENTERED_EMPTY,"Entered Empty");
        if(!this.isItExist(fileName))
            throw new AddressBookException(AddressBookException.ExceptionType.NOT_EXISTING,"File not Exists");
        try {
            String filePath = getFilePath(fileName);
            Gson gson = new Gson();
            Reader reader = Files.newBufferedReader(Paths.get(filePath));
            data.addAll(Arrays.asList(gson.fromJson(reader, Person[].class)));
            reader.close();
        } catch (IOException | RuntimeException e) {
            throw  new AddressBookException(AddressBookException.ExceptionType.FILE_PROBLEM,"Invalid File");
        }
        return data;
    }

    public void writeInFile(String fileName,Object object) throws AddressBookException {
        try {
            String filePath = getFilePath(fileName);
            Gson gson = new Gson();
            String json = gson.toJson(object);
            FileWriter writer = new FileWriter(filePath);
            writer.write(json);
            writer.close();
        } catch (IOException e) {
            throw new AddressBookException(AddressBookException.ExceptionType.FILE_PROBLEM,"Invalid File");
        }
    }
}
