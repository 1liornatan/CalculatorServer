package com.mta.kaplat.controller;

import com.mta.kaplat.service.LogsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class LogsController {

    final LogsService service;

    @GetMapping("/logs/level")
    public String getLevel(@RequestParam("logger-name") String loggerName) {
        return service.getLoggerLevel(loggerName);
    }

    @PutMapping("/logs/level")
    public String setLevel(@RequestParam("logger-name") String loggerName, @RequestParam("logger-level") String loggerLevel) {
        return service.setLoggerLevel(loggerName, loggerLevel);
    }
}
