package br.com.deresende.meme.comum.metrics;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Aspect
@Component
public class EndpointMetricsAspect {
    
    @Autowired
    private MeterRegistry meterRegistry;
    
    @Around("@annotation(org.springframework.web.bind.annotation.GetMapping) || " +
            "@annotation(org.springframework.web.bind.annotation.PostMapping) || " +
            "@annotation(org.springframework.web.bind.annotation.PutMapping) || " +
            "@annotation(org.springframework.web.bind.annotation.DeleteMapping)")
    public Object measureEndpointTiming(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        String className = joinPoint.getSignature().getDeclaringTypeName();
        String endpointName = className + "." + methodName;
        
        Timer.Sample sample = Timer.start(meterRegistry);
        
        try {
            return joinPoint.proceed();
        } catch (Exception e) {
            // Incrementa contador de erros
            meterRegistry.counter("endpoint.errors", "endpoint", endpointName).increment();
            throw e;
        } finally {
            // Registra tempo de execução
            sample.stop(Timer.builder("endpoint.execution.time")
                    .tag("endpoint", endpointName)
                    .register(meterRegistry));
            
            // Incrementa contador de requisições
            meterRegistry.counter("endpoint.requests", "endpoint", endpointName).increment();
        }
    }
}