package com.mta.kaplat.logic.math;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Stack;


@Component
public class Calculator {
    private final Stack<Integer> numbersStack;

    public Calculator() {
        numbersStack = new Stack<>();
    }

    public static Integer makeOperation(Operations operation, List<Integer> arguments) {
        int num1 = arguments.get(0);
        int num2 = arguments.get(1);

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

    public void push(int num) {
        numbersStack.push(num);
    }

    public Integer pop() {
        return numbersStack.pop();
    }

    public boolean isContainNumbers(int amount) {
        return (numbersStack.size() >= amount);
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
        return num1 / num2;
    }

    public static Integer pow(int num1, int num2) {
        return (int)(Math.pow(num1, num2));
    }

    public static Integer abs(int num) {
        return Math.abs(num);
    }

    public static Integer fact(int num) {
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
