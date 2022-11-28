package com.mta.kaplat.controller.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(
        value = HttpStatus.CONFLICT,
        reason = "Not enough arguments were given"
)
public class NotEnoughArgsException extends RuntimeException {

    public NotEnoughArgsException(String message) {
        super(message);
    }
}
