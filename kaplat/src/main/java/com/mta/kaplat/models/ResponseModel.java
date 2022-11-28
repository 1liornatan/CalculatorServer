package com.mta.kaplat.models;

import lombok.Getter;

@Getter
public class ResponseModel {
    Integer result;
    String errorMessage;

    public ResponseModel(Integer result, String errorMessage) {
        this.result = result;
        this.errorMessage = errorMessage;
    }
}
