package com.mta.kaplat.controller;

import com.mta.kaplat.constants.Constants;
import com.mta.kaplat.logic.math.Calculator;
import com.mta.kaplat.logic.math.Operations;
import com.mta.kaplat.models.ResponseModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OperateController {

    final Calculator calculator;

    public OperateController(Calculator calculator) {
        this.calculator = calculator;
    }

    @GetMapping("/stack/operate")
    public ResponseEntity<ResponseModel> operate(String operation) {
        Operations opr = Operations.valueOf(operation.toUpperCase());

        int size = calculator.size();
        switch (opr) {
            case PLUS, MINUS, TIMES, POW, DIVIDE -> {
                if (size < 2) {
                    return ResponseEntity.status(HttpStatus.CONFLICT)
                            .body(new ResponseModel(-1,
                                    String.format("Error: cannot implement operation %s. It requires 2 arguments and the stack has only %d arguments",
                                            operation, size)));
                }
            }
            case FACT, ABS -> {
                if (size < 1) {
                    return ResponseEntity.status(HttpStatus.CONFLICT)
                            .body(new ResponseModel(-1, String.format("Error: cannot implement operation %s. It requires 2 arguments and the stack has only %d arguments",
                                    operation, size)));
                }
            }
            default -> {
                // ERROR NO OPERATION
                return ResponseEntity.status(HttpStatus.CONFLICT)
                        .body(new ResponseModel(-1, Constants.ERROR_NO_OPERATION + operation));
            }
        }

        try {
            Integer result = calculator.makeOperation(opr);
            return ResponseEntity.ok(new ResponseModel(result, ""));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(new ResponseModel(-1, e.getMessage()));
        }
    }
}
