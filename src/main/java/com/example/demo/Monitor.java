package com.example.demo;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Monitor {

    private MeterRegistry meterRegistry;

    public Monitor( @Autowired MeterRegistry meterRegistry) {
        this.meterRegistry = meterRegistry;
    }

    private Counter successCounter;

    public void logSuccess() {
        successCounter  = Counter.builder("success.counter")
                .tags("status", "success")
                .baseUnit("counter")
                .description("Success number")
                .register(meterRegistry);
        successCounter.increment();
    }

}
