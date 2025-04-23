package com.example.implementations.trace.domain.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.time.Instant;

@Getter
@ToString
public class Trace {
    private final String message;
    private final long executionTime;
    private final Instant timestamp;

    public Trace(){
        this.message = "";
        this.executionTime = 0;
        this.timestamp = Instant.now();
    }

    public Trace(String message) {
        this.message = message;
        this.executionTime = 0;
        this.timestamp = Instant.now();
    }

    public Trace(String message, long executionTime) {
        this.message = message;
        this.executionTime = executionTime;
        this.timestamp = Instant.now();
    }

}
