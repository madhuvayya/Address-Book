package com.addressbook;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Comparators {

    static Map<AddressBook.CompareBy , Comparator<Person>> comparatorsMap = new HashMap<>();

    static {
        Comparator<Person> compareByFirstName = Comparator.comparing(person -> person.firstName);
        Comparator<Person> compareByZip = Comparator.comparing(person -> person.zip);

        comparatorsMap.put(AddressBook.CompareBy.FIRST_NAME,compareByFirstName);
        comparatorsMap.put(AddressBook.CompareBy.ZIP,compareByZip);
    }

    public Comparator<Person> getComparator(AddressBook.CompareBy compareBy) {
        return comparatorsMap.get(compareBy);
    }
}
