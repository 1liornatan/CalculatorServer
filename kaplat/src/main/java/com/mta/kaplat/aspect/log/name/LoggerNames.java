package com.mta.kaplat.aspect.log.name;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum LoggerNames {
    REQUESTS("requester-logger", "INFO"),
    STACK("stack-logger", "INFO"),
    INDEPENDENT("independent-logger", "DEBUG");

    private final String name;
    private final String defaultLevel;
}
