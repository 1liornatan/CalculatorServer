package com.mta.kaplat.models;

import java.util.List;

public class IndependentModel {
    List<Integer> numbersList;
    String operation;

    public IndependentModel(List<Integer> numbersList, String operation) {
        this.numbersList = numbersList;
        this.operation = operation;
    }

    public List<Integer> getNumbersList() {
        return numbersList;
    }

    public String getOperation() {
        return operation;
    }
}
