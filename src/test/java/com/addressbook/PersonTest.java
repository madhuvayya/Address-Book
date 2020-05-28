package com.addressbook;

import org.junit.Assert;
import org.junit.Test;

public class PersonTest {

    @Test
    public void givenPersonDetails_whenPersonObjectCreated_shouldReturnFirstName() {
        Person person = new Person("madhu", "vayya", "kukatpally", "Hyderabad",
                "Telangana", "500072", "7680012101");
        String firstName = person.getFirstName();
        Assert.assertEquals("madhu",firstName);
    }

    @Test
    public void givenPersonDetails_whenPersonObjectCreated_shouldReturnZipCode() {
        Person person = new Person("abcd", "abcv", "xyz colony", "Banglore",
                "karnataka", "6021072", "9999999999");
        String zip = person.getZip();
        Assert.assertEquals("6021072",zip);
    }

    @Test
    public void givenPersonDetails_whenPersonObjectCreated_shouldReturnNotEqualZipCode() {
        Person person = new Person("efgh", "mdjdb", "ms Apartment", "chennai",
                "Tamil Nadu", "701243", "7777777777");
        String zip = person.getZip();
        Assert.assertNotEquals("6666666",zip);
    }

    @Test
    public void givenPersonDetails_whenPersonObjectCreated_shouldNotEqualToActualPhone() {
        Person person = new Person("", "abcv", "mvp nagar", "vijawada",
                "Andhra Pradhesh", "11111111", "8888888888");
        String phone = person.getPhone();
        Assert.assertNotEquals("7777777",phone);
    }
}
