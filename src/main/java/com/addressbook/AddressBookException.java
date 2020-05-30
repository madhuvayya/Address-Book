package com.addressbook;

public class AddressBookException extends RuntimeException {

    enum ExceptionType {
        ENTERED_EMPTY,
        EXISTING,
        NOT_EXISTING,
        BOOK_IS_EMPTY,
        FILE_NOT_CREATED,
        ENTERED_NULL,
        FILE_PROBLEM,
        FILE_EXISTS
    }

    ExceptionType type;

    public AddressBookException(ExceptionType type, String message) {
        super(message);
        this.type = type;
    }
}
