package com.mta.kaplat.logic.math;

public enum Operations {
    PLUS("Plus", 2),
    MINUS("Minus", 2),
    TIMES("Times", 2),
    DIVIDE("Divide", 2),
    POW("Pow", 2),
    ABS("Abs", 1),
    FACT("Fact", 1);

    private final String operationName;
    private final Integer requiredArgs;

    Operations(String operationName, Integer requiredArgs) {
        this.operationName = operationName;
        this.requiredArgs = requiredArgs;
    }

    public Integer getRequiredArgs() {
        return requiredArgs;
    }

    @Override
    public String toString() {
        return operationName;
    }
}
