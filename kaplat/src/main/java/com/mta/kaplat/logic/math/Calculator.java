package com.mta.kaplat.logic.math;

import com.mta.kaplat.constant.Constants;
import com.mta.kaplat.controller.exceptions.DivideInZeroException;
import com.mta.kaplat.controller.exceptions.NegativeFactException;

import java.util.List;


public class Calculator {

    public static Integer makeIndependentOperation(Operations operation, List<Integer> arguments) {
        int num1 = arguments.get(0);
        int num2 = 1;

        if(arguments.size() > 1)
            num2 = arguments.get(1);

        return getResult(operation, num1, num2);

    }

    public static Integer makeOperation(Operations operation, List<Integer> numbersList) {
        int num1 = numbersList.get(0);
        int num2 = 1;

        Integer requiredArgs = operation.getRequiredArgs();

        if(requiredArgs > 1)
            num2 = numbersList.get(1);

        return getResult(operation, num1, num2);
    }

    private static Integer getResult(Operations operation, int num1, int num2) {
        return switch (operation) {
            case PLUS -> plus(num1, num2);
            case MINUS -> minus(num1, num2);
            case TIMES -> times(num1, num2);
            case DIVIDE -> divide(num1, num2);
            case POW -> pow(num1, num2);
            case FACT -> fact(num1);
            case ABS -> abs(num1);
        };
    }

    public static Integer plus(int num1, int num2) {
        return num1 + num2;
    }

    public static Integer minus(int num1, int num2) {
        return num1 - num2;
    }

    public static Integer times(int num1, int num2) {
        return num1 * num2;
    }

    public static Integer divide(int num1, int num2) {
        if(num2 == 0)
            throw new DivideInZeroException(Constants.ERROR_DIVIDE_ZERO);

        return num1 / num2;
    }

    public static Integer pow(int num1, int num2) {
        return (int)(Math.pow(num1, num2));
    }

    public static Integer abs(int num) {
        return Math.abs(num);
    }

    public static Integer fact(int num) {
        if(num < 0)
            throw new NegativeFactException(Constants.ERROR_FACT_NEGATIVE);

        return calcFactorial(num);
    }

    private static Integer calcFactorial(int num) {
        int fact = 1;
        for(int i = 2; i <= num; i++) {
            fact *= i;
        }

        return fact;
    }

}
