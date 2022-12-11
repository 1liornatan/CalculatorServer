package com.mta.kaplat.service;

import com.mta.kaplat.controller.exceptions.NotEnoughArgsException;
import com.mta.kaplat.logic.math.Calculator;
import com.mta.kaplat.logic.math.NumbersStack;
import com.mta.kaplat.logic.math.Operations;
import com.mta.kaplat.logic.math.Validator;
import com.mta.kaplat.models.ResponseModel;
import com.mta.kaplat.models.StackArgumentsModel;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service("stack-service")
public class StackService {
    final NumbersStack stack;

    public ResponseModel stackArgs(StackArgumentsModel data) {
        data.getArguments().forEach(stack::push);
        return new ResponseModel(stack.size(), "");
    }

    public ResponseEntity<ResponseModel> deleteArgs(Integer count) {
        int size = stack.size();

        if(size < count)
            throw new RuntimeException(String.format("Error: cannot remove %d from the stack. It has only %d arguments", count, size));

        stack.delete(count);

        return ResponseEntity.ok(new ResponseModel(stack.size(), ""));
    }

    public ResponseModel getStackSize() {
        return new ResponseModel(stack.size(), "");
    }

    public ResponseEntity<ResponseModel> operate(String operation) {
        Operations opr = Validator.lookup(operation);
        int size = stack.size();
        Integer requiredArgs = opr.getRequiredArgs();

        if (size < requiredArgs)
            throw new NotEnoughArgsException(operation, requiredArgs, size);

        Integer result = Calculator.makeOperation(opr, stack.popToList(requiredArgs));
        return ResponseEntity.ok(new ResponseModel(result, ""));
    }
}
