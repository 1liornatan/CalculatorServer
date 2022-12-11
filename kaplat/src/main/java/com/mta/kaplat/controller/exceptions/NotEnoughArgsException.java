package com.mta.kaplat.controller.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class NotEnoughArgsException extends RuntimeException {

    public NotEnoughArgsException(String operation, Integer required, Integer size) {
        super(String.format("Error: cannot implement operation %s. It requires %d arguments and the stack has only %d arguments",
                operation, required, size));
    }
}
