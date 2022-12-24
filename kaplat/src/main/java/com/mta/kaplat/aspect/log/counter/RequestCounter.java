package com.mta.kaplat.aspect.log.counter;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Getter
public class RequestCounter {
    private int count = 0;

    public int increase() {
        return ++count;
    }
}
