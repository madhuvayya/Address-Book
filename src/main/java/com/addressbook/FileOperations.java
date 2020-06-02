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

    public boolean isEmpty(String fileName){
        File file = new File(this.getFilePath(fileName));
        return file.length() == 0;
    }

    private String getFilePath(String fileName) throws AddressBookException {
        if (fileName.equals(""))
            throw new AddressBookException( AddressBookException.ExceptionType.ENTERED_EMPTY,"Entered Empty");
        return  "./src/main/resources/"+fileName+".json";
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
        try (Reader reader = Files.newBufferedReader(Paths.get(this.getFilePath(fileName)))) {
            Gson gson = new Gson();
            data.addAll(Arrays.asList(gson.fromJson(reader, Person[].class)));
        } catch (IOException | RuntimeException e) {
            throw  new AddressBookException(AddressBookException.ExceptionType.FILE_PROBLEM,"Invalid File");
        }
        return data;
    }

    public void writeInFile(String fileName,Object object) throws AddressBookException {
        try(FileWriter writer = new FileWriter(this.getFilePath(fileName))) {
            Gson gson = new Gson();
            writer.write( gson.toJson(object) );
        } catch (IOException e) {
            throw new AddressBookException(AddressBookException.ExceptionType.FILE_PROBLEM,"Invalid File");
        }
    }

    public void deleteFile(String fileName) {
        File file = new File(this.getFilePath(fileName));
        file.delete();
    }

    public int loadFiles() {
        String directory = "./src/main/resources/";
        File dir = new File(directory);
        File[] files = dir.listFiles((dir1, name) -> name.endsWith(".json"));
        return files.length;
    }
}
