package com.mta.kaplat.controller;

import com.mta.kaplat.logic.math.Calculator;
import com.mta.kaplat.models.ResponseModel;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class StackSizeController {

    final Calculator calculator;

    @GetMapping("/stack/size")
    public ResponseModel stackSize() {
        return new ResponseModel(calculator.size(), "");
    }
}
