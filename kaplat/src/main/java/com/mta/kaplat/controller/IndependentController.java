package com.mta.kaplat.controller;

import com.mta.kaplat.model.IndependentModel;
import com.mta.kaplat.model.ResponseModel;
import com.mta.kaplat.service.IndependentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RequiredArgsConstructor
@RestController
public class IndependentController {
    final IndependentService independentService;

    @PostMapping("/independent/calculate")
    public ResponseModel operate(@RequestBody IndependentModel data) {
        return new ResponseModel(independentService.calculate(data.getOperation(), data.getArguments()), "");
    }
}
