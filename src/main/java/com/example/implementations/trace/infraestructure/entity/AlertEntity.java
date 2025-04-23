package com.example.implementations.trace.infraestructure.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "alerts")
public class AlertEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private Instant timestamp;

    @Enumerated(EnumType.STRING)
    private AlertType type;

    private String message;
    private String details;
    private String source;
    private String userId;

    private boolean read;
    private boolean resolved;

    @Enumerated(EnumType.STRING)
    private SeverityEnum severity;

}
