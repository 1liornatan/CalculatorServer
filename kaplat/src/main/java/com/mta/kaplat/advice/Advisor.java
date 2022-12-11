package com.mta.kaplat.advice;

import com.mta.kaplat.models.ResponseModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class Advisor {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ResponseModel> handleRuntimeException(RuntimeException e, WebRequest request) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(new ResponseModel(-1, e.getMessage()));
    }


}
