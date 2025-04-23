package com.example.implementations.trace.infraestructure.mappers;

import com.example.implementations.trace.domain.models.Trace;
import com.example.implementations.trace.infraestructure.entity.TraceEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TraceEntityMapper {
    @Mapping(target = "id", ignore = true)
    TraceEntity toEntity(Trace trace);

    Trace toTrace(TraceEntity entity);
}
