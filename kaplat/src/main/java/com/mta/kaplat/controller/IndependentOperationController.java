package com.mta.kaplat.controller;

import com.mta.kaplat.constants.Constants;
import com.mta.kaplat.logic.math.Calculator;
import com.mta.kaplat.logic.math.Operations;
import com.mta.kaplat.models.IndependentModel;
import com.mta.kaplat.models.ResponseModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class IndependentOperationController {

    @PostMapping("/independent/calculate")
    public ResponseEntity<ResponseModel> operate(@RequestBody IndependentModel data) {
        List<Integer> arguments = data.getArguments();
        String reqOperation = data.getOperation();
        Operations operation;
        try {
            operation = Operations.valueOf(reqOperation.toUpperCase());
            int size = arguments.size();

            switch (operation) {
                case PLUS, MINUS, TIMES, POW, DIVIDE -> {
                    if (size > 2) {
                        return ResponseEntity.status(HttpStatus.CONFLICT)
                                .body(new ResponseModel(-1, Constants.ERROR_TOO_MANY_ARGUMENTS + reqOperation));
                    } else if (size < 2) {
                        return ResponseEntity.status(HttpStatus.CONFLICT)
                                .body(new ResponseModel(-1, Constants.ERROR_NO_ARGUMENTS + reqOperation));
                    }
                }
                case FACT, ABS -> {
                    if (size > 1) {
                        return ResponseEntity.status(HttpStatus.CONFLICT)
                                .body(new ResponseModel(-1, Constants.ERROR_TOO_MANY_ARGUMENTS + reqOperation));
                    } else if (size < 1) {
                        return ResponseEntity.status(HttpStatus.CONFLICT)
                                .body(new ResponseModel(-1, Constants.ERROR_NO_ARGUMENTS + reqOperation));
                    }
                }
            }


            try {
                Integer result = Calculator.makeIndependentOperation(operation, arguments);
                return ResponseEntity.ok(new ResponseModel(result, ""));
            } catch (RuntimeException e) {
                return ResponseEntity.status(HttpStatus.CONFLICT).body(new ResponseModel(-1, e.getMessage()));
            }
        } catch (IllegalArgumentException e) {
            // ERROR NO OPERATION
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body(new ResponseModel(-1, Constants.ERROR_NO_OPERATION + reqOperation));
        }
    }
}
