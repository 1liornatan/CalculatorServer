package com.mta.kaplat.advice;

import com.mta.kaplat.constant.Constants;
import com.mta.kaplat.model.ResponseModel;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@ControllerAdvice
public class Advisor {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ResponseModel> handleRuntimeException(RuntimeException e) {
        HttpServletRequest httpServletRequest = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        String requestURI = httpServletRequest.getRequestURI();
        Logger logger = getTargetLogger(requestURI);

        if(logger != null)
            logger.error("Server encountered an error ! message: " + e.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(new ResponseModel(null, e.getMessage()));
    }

    private Logger getTargetLogger(String URI) {
        if(URI.contains("stack"))
            return LogManager.getLogger(Constants.LOGGER_STACK);
        else if(URI.contains("independent"))
            return LogManager.getLogger(Constants.LOGGER_INDEPENDENT);

        return null;
    }


}
