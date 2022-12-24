package com.mta.kaplat.logic.math;

import com.mta.kaplat.constant.Constants;
import com.mta.kaplat.logic.exceptions.NoSuchOperationException;

public class Validator {
    public static Operations lookup(String opr) {
        try {
            return Operations.valueOf(opr.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new NoSuchOperationException(Constants.ERROR_NO_OPERATION + opr);
        }
    }
}
