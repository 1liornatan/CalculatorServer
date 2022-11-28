package com.mta.kaplat.controller;

import com.mta.kaplat.logic.math.Calculator;
import com.mta.kaplat.logic.math.Operations;
import com.mta.kaplat.models.IndependentModel;
import com.mta.kaplat.models.ResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class OperationController {

    @Autowired
    Calculator calculator;

    @RequestMapping("/independent/calculate")
    public ResponseModel HelloWorld(IndependentModel data) {
        List<Integer> arguments = data.getNumbersList();
        Operations operation = Operations.valueOf(data.getOperation().toUpperCase());

        int size = arguments.size();

        switch(operation) {
            case PLUS, MINUS, TIMES, POW, DIVIDE: {
                if (size > 2) {
                    // ERROR TOO MANY
                } else if (size < 2) {
                    // ERROR MISSING ARGS
                }
                break;
            }

            case FACT, ABS: {
                if (size > 1) {
                    // ERROR TOO MANY
                } else if (size < 1) {
                    // ERROR NOT ENOUGH
                }
                break;
            }

            default: {
                // ERROR NO OPERATION
            }
        }

        return new ResponseModel(Calculator.makeOperation(operation, arguments), "");
    }
}
