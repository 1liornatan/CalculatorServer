package com.mta.kaplat.controller;

import com.mta.kaplat.logic.math.Calculator;
import com.mta.kaplat.models.ResponseModel;
import com.mta.kaplat.models.StackArgumentsModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StackArgumentsController {

    final Calculator calculator;

    public StackArgumentsController(Calculator calculator) {
        this.calculator = calculator;
    }

    @PutMapping("/stack/arguments")
    public ResponseModel stackArguments(@RequestBody StackArgumentsModel data) {
        data.getArguments().forEach(calculator::push);

        return new ResponseModel(calculator.size(), "");
    }

    @DeleteMapping("/stack/arguments")
    public ResponseEntity<ResponseModel> deleteArguments(Integer count) {
        int size = calculator.size();

        if(size < count)
            return ResponseEntity.status(HttpStatus.CONFLICT).body(new ResponseModel(-1,
                    String.format("Error: cannot remove %d from the stack. It has only %d arguments", count, size)));

        calculator.delete(count);

        return ResponseEntity.ok(new ResponseModel(calculator.size(), ""));
    }

}
