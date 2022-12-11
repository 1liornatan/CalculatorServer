package com.mta.kaplat.controller.exceptions;

import com.mta.kaplat.constants.Constants;

public class NotEnoughArgsIndependentException extends RuntimeException {

    public NotEnoughArgsIndependentException(String opr) {
        super(Constants.ERROR_NO_ARGUMENTS + opr);
    }
}
