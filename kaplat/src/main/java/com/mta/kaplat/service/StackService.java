package com.mta.kaplat.service;

import com.mta.kaplat.controller.exceptions.NotEnoughArgsException;
import com.mta.kaplat.logic.math.Calculator;
import com.mta.kaplat.logic.math.NumbersStack;
import com.mta.kaplat.logic.math.Operations;
import com.mta.kaplat.logic.math.Validator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service("stack-service")
public class StackService {
    final NumbersStack stack;

    public Integer stackArgs(List<Integer> data) {
        data.forEach(stack::push);
        return stack.size();
    }

    public Integer deleteArgs(Integer count) {
        int size = stack.size();

        if(size < count)
            throw new RuntimeException(String.format("Error: cannot remove %d from the stack. It has only %d arguments", count, size));

        stack.delete(count);

        return stack.size();
    }

    public Integer getStackSize() {
        return stack.size();
    }

    public Integer operate(String operation) {
        Operations opr = Validator.lookup(operation);
        int size = stack.size();
        Integer requiredArgs = opr.getRequiredArgs();

        if (size < requiredArgs)
            throw new NotEnoughArgsException(operation, requiredArgs, size);

        return Calculator.makeOperation(opr, stack.popToList(requiredArgs));
    }
}
