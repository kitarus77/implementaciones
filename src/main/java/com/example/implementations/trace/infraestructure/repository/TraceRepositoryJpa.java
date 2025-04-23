package com.example.implementations.trace.infraestructure.repository;

import com.example.implementations.trace.domain.models.Trace;
import com.example.implementations.trace.domain.repository.TraceRepository;
import com.example.implementations.trace.infraestructure.entity.TraceEntity;
import com.example.implementations.trace.infraestructure.mappers.TraceEntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class TraceRepositoryJpa implements TraceRepository {

    private final TraceJpaRepository traceJpaRepository;
    private final TraceEntityMapper traceEntityMapper;

    @Override
    public void trace(Trace trace) {
        TraceEntity traceEntity = traceEntityMapper.toEntity(trace);
        this.traceJpaRepository.save(traceEntity);
    }
}
