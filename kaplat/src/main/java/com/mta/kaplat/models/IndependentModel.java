package com.mta.kaplat.models;

import lombok.Getter;

import java.util.List;

@Getter
public class IndependentModel {
    List<Integer> arguments;
    String operation;

    public IndependentModel(List<Integer> arguments, String operation) {
        this.arguments = arguments;
        this.operation = operation;
    }
}
