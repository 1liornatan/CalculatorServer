package com.mta.kaplat.models;

public class ResponseModel {
    Integer result;
    String errorMessage;

    public ResponseModel(Integer result, String errorMessage) {
        this.result = result;
        this.errorMessage = errorMessage;
    }

    public Integer getResult() {
        return result;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
