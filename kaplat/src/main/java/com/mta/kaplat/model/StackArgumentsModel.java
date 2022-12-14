package com.mta.kaplat.model;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class StackArgumentsModel {
    List<Integer> arguments;

    public StackArgumentsModel() {
        arguments = new ArrayList<>();
    }

    public List<Integer> getArguments() {
        return arguments;
    }
}
