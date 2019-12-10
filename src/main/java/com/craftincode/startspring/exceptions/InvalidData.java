package com.craftincode.startspring.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidData extends Exception {
    public InvalidData(String message) {
        super(message);
    }
}
