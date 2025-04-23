package com.example.implementations.aoplogs.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AutoLogAspect {

    private static final Logger logger = LoggerFactory.getLogger(AutoLogAspect.class);

    @Around("@annotation(com.example.implementations.aoplogs.annotations.AutoLog)")
    public Object logMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String methodName = signature.getDeclaringType().getSimpleName() + "." + signature.getName();

        logger.info("Ejecutando método: {}", methodName);

        try {
            Object result = joinPoint.proceed();
            logger.info("Método terminó correctamente: {}", methodName);
            return result;
        } catch (Throwable ex) {
            logger.error("Ocurrió una excepción en: {}", methodName, ex);
            throw ex;
        }
    }
}
