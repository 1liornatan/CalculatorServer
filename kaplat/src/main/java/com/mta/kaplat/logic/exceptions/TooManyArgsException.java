package com.mta.kaplat.logic.exceptions;

import com.mta.kaplat.constant.Constants;

public class TooManyArgsException extends RuntimeException {

    public TooManyArgsException(String opr) {
        super(Constants.ERROR_TOO_MANY_ARGUMENTS + opr);
    }
}