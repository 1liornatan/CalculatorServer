package com.mta.kaplat.controller;

import clojure.lang.Cons;
import com.mta.kaplat.constant.Constants;
import com.mta.kaplat.model.ResponseModel;
import com.mta.kaplat.model.StackArgumentsModel;
import com.mta.kaplat.service.StackService;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class StackController {

    final StackService service;

    @PutMapping("/stack/arguments")
    public ResponseModel stackArguments(@RequestBody StackArgumentsModel data) {
        Logger logger = LogManager.getLogger(Constants.LOGGER_STACK);
        Integer stackSizeBefore = service.getStackSize();
        Integer stackSizeAfter = service.stackArgs(data.getArguments());
        Integer arguments = data.getArguments().size();
        logger.info(String.format("Adding total of %d argument(s) to the stack | Stack size: %d", arguments, stackSizeAfter));
        logger.debug("Adding arguments: %s | Stack size before %d | stack size after %d",
                data.getArguments().toString(), stackSizeBefore, stackSizeAfter);
        return new ResponseModel(stackSizeAfter, "");
    }

    @GetMapping("/stack/size")
    public ResponseModel stackSize() {
        Logger logger = LogManager.getLogger(Constants.LOGGER_STACK);
        Integer stackSize = service.getStackSize();
        logger.info(String.format("Stack size is %d", stackSize));
        logger.info(String.format("Stack content (first == top): %s", service.getStackContent()));
        return new ResponseModel(stackSize, "");
    }

    @DeleteMapping("/stack/arguments")
    public ResponseModel deleteArguments(Integer count) {
        Logger logger = LogManager.getLogger(Constants.LOGGER_STACK);
        Integer stackSize = service.deleteArgs(count);
        logger.info(String.format("Removing total %d argument(s) from the stack | Stack size: %d",
                count, stackSize));
        return new ResponseModel(stackSize, "");
    }

    @GetMapping("/stack/operate")
    public ResponseModel operate(String operation) {
        Logger logger = LogManager.getLogger(Constants.LOGGER_STACK);
        Integer calculate = service.calculate(operation);
        Integer stackSizeAfter = service.getStackSize();

        logger.info(String.format("Performing operation %s. Result is %d | stack size: %d",
                operation, calculate, stackSizeAfter));
        logger.debug("Performing operation: %s(%s) = %d", operation, service.getLastCalculateArgs(), calculate);
        return new ResponseModel(calculate, "");
    }
}
