package com.mta.kaplat.logic.math;

public enum Operations {
    PLUS("Plus"),
    MINUS("Minus"),
    TIMES("Times"),
    DIVIDE("Divide"),
    POW("Pow"),
    ABS("Abs"),
    FACT("Fact");

    private final String operationName;

    Operations(String operationName) {
        this.operationName = operationName;
    }

    @Override
    public String toString() {
        return operationName;
    }
}
