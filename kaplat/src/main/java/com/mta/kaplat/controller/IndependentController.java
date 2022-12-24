package com.mta.kaplat.controller;

import com.mta.kaplat.constant.Constants;
import com.mta.kaplat.model.IndependentModel;
import com.mta.kaplat.model.ResponseModel;
import com.mta.kaplat.service.IndependentService;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RequiredArgsConstructor
@RestController
public class IndependentController {
    final IndependentService independentService;

    @PostMapping("/independent/calculate")
    public ResponseModel operate(@RequestBody IndependentModel data) {
        Logger logger = LogManager.getLogger(Constants.LOGGER_INDEPENDENT);
        List<Integer> arguments = data.getArguments();
        String operation = data.getOperation();
        Integer calculate = independentService.calculate(operation, arguments);

        logger.info(String.format("Performing operation %s. Result is %d",
                operation, calculate));
        logger.debug(String.format("Performing operation: %s(%s) = %d",
                operation,
                arguments.toString().replace("[", "").replace("]", "").trim(), calculate));
        return new ResponseModel(calculate, "");
    }
}
