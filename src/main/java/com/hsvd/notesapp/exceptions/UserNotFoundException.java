package com.hsvd.notesapp.exceptions;

public class UserNotFoundException extends RuntimeException {
    
    public UserNotFoundException(String username) {
        super("The user with " + username + " does not exist in our records");
    }

}
