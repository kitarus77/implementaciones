package com.example.implementations.trace.aspects;

import com.example.implementations.trace.application.TraceOperationUseCase;
import com.example.implementations.trace.infraestructure.entity.AlertEntity;
import com.example.implementations.trace.infraestructure.entity.AlertType;
import com.example.implementations.trace.infraestructure.entity.SeverityEnum;
import com.example.implementations.trace.infraestructure.repository.AlertJpaRepository;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Aspect
@Component
@RequiredArgsConstructor
public class AutoTraceAspect {

    final long MAX_DURATION_ALERT = 3000;
    private final TraceOperationUseCase traceOperationUseCase;
    private final AlertJpaRepository alertJpaRepository;

    @Around("@annotation(com.example.implementations.trace.annotations.AutoTrace)")
    public Object logMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        try {
            this.traceOperationUseCase.execute("Ejecutando proceso X");
            long start = System.currentTimeMillis();
            Object result = joinPoint.proceed();
            long duration = System.currentTimeMillis() - start;
            this.traceOperationUseCase.execute(String.format("Proceso X ejecutado con éxito"), duration);

            this.checkExecutionTime(duration, joinPoint);

            return result;
        } catch (Throwable ex) {
            this.traceOperationUseCase.execute("Error al ejecutar proceso X");
            throw ex;
        }
    }

    private void checkExecutionTime(long duration, ProceedingJoinPoint joinPoint) {
        String metodo = joinPoint.getSignature().getName();
        String clase = joinPoint.getSignature().getDeclaringTypeName();

        if(duration >= MAX_DURATION_ALERT) {
            AlertEntity alert = AlertEntity.builder()
                    .message("Proceso X tardó demasiado en ejecutarse")
                    .details(String.format("Tiempo de ejecución=%dms", duration))
                    .type(AlertType.WARNING)
                    .severity(duration > MAX_DURATION_ALERT+1000 ? SeverityEnum.CRITICA : SeverityEnum.NORMAL)
                    .source(String.format("Class=%s, Method=%s", clase, metodo))
                    .timestamp(Instant.now())
                    .userId("usuario@gmail.com") // Se puede obtener del método a través del Principal
                    .build();
            this.alertJpaRepository.save(alert);
        }
    }

    // Ejemplo para buscar el argumento Principal y extraer el usuario
//    private String extractUserFromPrincipal(ProceedingJoinPoint joinPoint) {
//        Optional<Principal> maybePrincipal = Arrays.stream(joinPoint.getArgs())
//                .filter(arg -> arg instanceof Principal)
//                .map(arg -> (Principal) arg)
//                .findFirst();
//
//        maybePrincipal.ifPresent(principal -> {
//            return principal.getName();
//        });
//        return null;
//    }
}
