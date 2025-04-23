package com.example.implementations.trace.infraestructure.repository;

import com.example.implementations.trace.infraestructure.entity.AlertEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AlertJpaRepository extends JpaRepository<AlertEntity, UUID> {
}
