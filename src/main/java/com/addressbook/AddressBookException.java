package com.addressbook;

public class AddressBookException extends RuntimeException {

    enum ExceptionType {
        ENTERED_EMPTY,
        EXISTING,
        NOT_EXISTING
    }

    ExceptionType type;

    public AddressBookException(ExceptionType type, String message) {
        super(message);
        this.type = type;
    }
}
