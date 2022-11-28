package com.mta.kaplat.controller.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(
        value = HttpStatus.CONFLICT,
        reason = "Divide in zero"
)
public class DivideInZeroException extends RuntimeException {

    public DivideInZeroException(String message) {
        super(message);
    }
}