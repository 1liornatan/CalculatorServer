package com.mta.kaplat.controller;

import com.mta.kaplat.models.ResponseModel;
import com.mta.kaplat.models.StackArgumentsModel;
import com.mta.kaplat.service.StackService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class StackController {

    final StackService service;

    @PutMapping("/stack/arguments")
    public ResponseModel stackArguments(@RequestBody StackArgumentsModel data) {
        return new ResponseModel(service.stackArgs(data.getArguments()), "");
    }

    @GetMapping("/stack/size")
    public ResponseModel stackSize() {
        return new ResponseModel(service.getStackSize(), "");
    }

    @DeleteMapping("/stack/arguments")
    public ResponseModel deleteArguments(Integer count) {
        return new ResponseModel(service.deleteArgs(count), "");
    }

    @GetMapping("/stack/operate")
    public ResponseModel operate(String operation) {
        return new ResponseModel(service.calculate(operation), "");
    }
}
