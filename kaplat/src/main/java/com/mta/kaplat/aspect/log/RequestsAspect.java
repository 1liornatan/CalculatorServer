package com.mta.kaplat.aspect.log;

import com.mta.kaplat.aspect.log.counter.RequestCounter;
import com.mta.kaplat.constant.Constants;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.time.Duration;
import java.time.Instant;


@RequiredArgsConstructor
@Component
@Aspect
public class RequestsAspect {
    final RequestCounter requestCounter;

    @Pointcut("within(com.mta.kaplat.controller.*)")
    public void inControllerLayer() {}

    @Around("inControllerLayer()")
    public Object test(ProceedingJoinPoint jp) throws Throwable {
        int currentCount = requestCounter.increase();
        HttpServletRequest httpServletRequest = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        String method = httpServletRequest.getMethod();
        String requestURI = httpServletRequest.getRequestURI();
        Logger logger = LogManager.getLogger(Constants.LOGGER_REQUEST);
        logger.info("Incoming request | #" + currentCount + " | resource: " + requestURI + " | HTTP Verb " + method);
        Instant start = Instant.now();
        Object proceed = jp.proceed();
        Instant end = Instant.now();
        logger.debug("request #" + currentCount + " duration: "+ Duration.between(start, end).toMillis() + "ms");
        return proceed;
    }

}
