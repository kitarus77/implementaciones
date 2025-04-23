package com.example.implementations.trace.application;

import com.example.implementations.trace.domain.models.Trace;
import com.example.implementations.trace.domain.repository.TraceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class TraceOperationUseCase {

    private final TraceRepository traceRepository;

    public void execute(String message) {
        this.traceRepository.trace(new Trace(message));
    }

    public void execute(String message, long executionTime) {
        this.traceRepository.trace(new Trace(message, executionTime));
    }
}
