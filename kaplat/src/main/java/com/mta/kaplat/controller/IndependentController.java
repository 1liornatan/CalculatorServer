package com.mta.kaplat.controller;

import com.mta.kaplat.constants.Constants;
import com.mta.kaplat.logic.math.Calculator;
import com.mta.kaplat.logic.math.Operations;
import com.mta.kaplat.models.IndependentModel;
import com.mta.kaplat.models.ResponseModel;
import com.mta.kaplat.service.IndependentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RequiredArgsConstructor
@RestController
public class IndependentController {
    final IndependentService independentService;

    @PostMapping("/independent/calculate")
    public ResponseEntity<ResponseModel> operate(@RequestBody IndependentModel data) {
        return independentService.operate(data);
    }
}
