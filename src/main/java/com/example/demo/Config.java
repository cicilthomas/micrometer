package com.example.demo;

import io.micrometer.core.instrument.Clock;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.statsd.StatsdConfig;
import io.micrometer.statsd.StatsdFlavor;
import io.micrometer.statsd.StatsdMeterRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
public MeterRegistry getMeterRegistry () {

    StatsdConfig config = new StatsdConfig (){

        @Override
        public StatsdFlavor flavor() {
            return StatsdFlavor.DATADOG;
        }

        @Override
        public String get(String key) {
            return null;
        }
    };

        return new StatsdMeterRegistry(config, Clock.SYSTEM);
}

}
