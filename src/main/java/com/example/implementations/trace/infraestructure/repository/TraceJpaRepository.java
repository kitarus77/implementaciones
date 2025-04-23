package com.example.implementations.trace.infraestructure.repository;

import com.example.implementations.trace.infraestructure.entity.TraceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TraceJpaRepository extends JpaRepository<TraceEntity, Long> {
}
