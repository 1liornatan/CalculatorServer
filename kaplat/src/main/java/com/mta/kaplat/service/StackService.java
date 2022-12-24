package com.mta.kaplat.service;

import com.mta.kaplat.logic.exceptions.NotEnoughArgsException;
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
    String lastCalculateArgs;

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

    public Integer calculate(String operation) {
        Operations opr = Validator.lookup(operation);
        int size = stack.size();
        Integer requiredArgs = opr.getRequiredArgs();

        if (size < requiredArgs)
            throw new NotEnoughArgsException(operation, requiredArgs, size);

        List<Integer> numbersList = stack.popToList(requiredArgs);
        updateCalculateArgs(numbersList);
        return Calculator.makeOperation(opr, numbersList);
    }

    private void updateCalculateArgs(List<Integer> numbersList) {
        int size = numbersList.size();
        if(size <= 0)
            return;

        lastCalculateArgs = numbersList.get(0).toString();
        for(int i = 1; i < size; i++) {
            lastCalculateArgs = lastCalculateArgs + "," + numbersList.get(i);
        }
    }

    public String getStackContent() {
        return stack.toString();
    }

    public String getLastCalculateArgs() {
        return lastCalculateArgs;
    }

}
