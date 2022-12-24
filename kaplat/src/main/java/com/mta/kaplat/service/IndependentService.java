package com.mta.kaplat.service;

import com.mta.kaplat.logic.exceptions.NotEnoughArgsIndependentException;
import com.mta.kaplat.logic.exceptions.TooManyArgsException;
import com.mta.kaplat.logic.math.Calculator;
import com.mta.kaplat.logic.math.Operations;
import com.mta.kaplat.logic.math.Validator;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("independent-service")
public class IndependentService {

    public Integer calculate(String reqOperation, List<Integer> arguments) {
        Operations operation = Validator.lookup(reqOperation);

        int size = arguments.size();
        Integer requiredArgs = operation.getRequiredArgs();

        if (size > requiredArgs)
            throw new TooManyArgsException(reqOperation);
        else if (size < requiredArgs)
            throw new NotEnoughArgsIndependentException(reqOperation);

        return Calculator.makeIndependentOperation(operation, arguments);
    }
}
