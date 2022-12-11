package com.mta.kaplat.service;

import com.mta.kaplat.constants.Constants;
import com.mta.kaplat.controller.exceptions.NotEnoughArgsIndependentException;
import com.mta.kaplat.controller.exceptions.TooManyArgsException;
import com.mta.kaplat.logic.math.Calculator;
import com.mta.kaplat.logic.math.Operations;
import com.mta.kaplat.logic.math.Validator;
import com.mta.kaplat.models.IndependentModel;
import com.mta.kaplat.models.ResponseModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("independent-service")
public class IndependentService {

    public ResponseEntity<ResponseModel> operate(IndependentModel data) {
        List<Integer> arguments = data.getArguments();
        String reqOperation = data.getOperation();
        Operations operation = Validator.lookup(reqOperation);

        int size = arguments.size();
        Integer requiredArgs = operation.getRequiredArgs();

        if (size > requiredArgs)
            throw new TooManyArgsException(reqOperation);
        else if (size < requiredArgs)
            throw new NotEnoughArgsIndependentException(reqOperation);

        Integer result = Calculator.makeIndependentOperation(operation, arguments);
        return ResponseEntity.ok(new ResponseModel(result, ""));
    }
}
