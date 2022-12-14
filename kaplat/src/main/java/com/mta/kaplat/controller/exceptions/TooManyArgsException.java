package com.mta.kaplat.controller.exceptions;

import com.mta.kaplat.constant.Constants;

public class TooManyArgsException extends RuntimeException {

    public TooManyArgsException(String opr) {
        super(Constants.ERROR_TOO_MANY_ARGUMENTS + opr);
    }
}