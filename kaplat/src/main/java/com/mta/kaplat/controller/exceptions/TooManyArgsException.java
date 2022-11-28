package com.mta.kaplat.controller.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(
        value = HttpStatus.CONFLICT,
        reason = "Too many arguments were given"
)
public class TooManyArgsException extends RuntimeException {

    public TooManyArgsException(String message) {
        super(message);
    }
}