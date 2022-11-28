package com.mta.kaplat.models;

import lombok.Getter;

import java.util.List;

@Getter
public record StackArgumentsModel(List<Integer> arguments) {
}
