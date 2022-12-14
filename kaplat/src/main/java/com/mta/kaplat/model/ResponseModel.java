package com.mta.kaplat.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;


@Getter
public class ResponseModel {
    Integer result;

    @JsonProperty(value = "error-message")
    String errorMessage;

    public ResponseModel(Integer result, String errorMessage) {
        this.result = result;
        this.errorMessage = errorMessage;
    }
}
