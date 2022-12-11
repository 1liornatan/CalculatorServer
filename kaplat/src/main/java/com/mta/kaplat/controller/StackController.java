package com.mta.kaplat.controller;

import com.mta.kaplat.constants.Constants;
import com.mta.kaplat.logic.math.Calculator;
import com.mta.kaplat.logic.math.Operations;
import com.mta.kaplat.models.ResponseModel;
import com.mta.kaplat.models.StackArgumentsModel;
import com.mta.kaplat.service.StackService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class StackController {

    final StackService service;

    @PutMapping("/stack/arguments")
    public ResponseModel stackArguments(@RequestBody StackArgumentsModel data) {
        return service.stackArgs(data);
    }

    @GetMapping("/stack/size")
    public ResponseModel stackSize() {
        return service.getStackSize();
    }

    @DeleteMapping("/stack/arguments")
    public ResponseEntity<ResponseModel> deleteArguments(Integer count) {
        return service.deleteArgs(count);
    }

    @GetMapping("/stack/operate")
    public ResponseEntity<ResponseModel> operate(String operation) {
        return service.operate(operation);
    }
}
