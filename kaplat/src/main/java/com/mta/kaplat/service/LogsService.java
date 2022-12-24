package com.mta.kaplat.service;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;
import org.springframework.stereotype.Service;

@Service("logs-service")
public class LogsService {

    public String getLoggerLevel(String loggerName) {
        Logger logger = LogManager.getLogger(loggerName);

        if(logger != null) {
            return logger.getLevel().name();
        }

        return "Error: Failure in getting logger level";
    }

    public String setLoggerLevel(String loggerName, String loggerLevel) {
        Logger logger = LogManager.getLogger(loggerName);

        if(logger != null) {
            Configurator.setLevel(loggerName, Level.valueOf(loggerLevel));
            return logger.getLevel().name();
        }

        return "Error: Failure in setting logger level";
    }
}
