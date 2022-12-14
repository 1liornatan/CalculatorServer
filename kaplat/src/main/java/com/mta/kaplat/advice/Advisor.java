package com.mta.kaplat.advice;

import com.mta.kaplat.model.ResponseModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class Advisor {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ResponseModel> handleRuntimeException(RuntimeException e) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(new ResponseModel(null, e.getMessage()));
    }


}
