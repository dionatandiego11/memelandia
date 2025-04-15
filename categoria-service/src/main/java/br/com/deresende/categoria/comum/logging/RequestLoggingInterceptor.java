package br.com.deresende.categoria.comum.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.UUID;

@Component
public class RequestLoggingInterceptor implements HandlerInterceptor {
    
    private static final Logger logger = LoggerFactory.getLogger(RequestLoggingInterceptor.class);
    
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        // Gerar ID de correlação para rastreamento
        String correlationId = UUID.randomUUID().toString();
        MDC.put("correlationId", correlationId);
        MDC.put("requestMethod", request.getMethod());
        MDC.put("requestURI", request.getRequestURI());
        
        logger.info("Iniciando processamento de requisição: {} {}", request.getMethod(), request.getRequestURI());
        
        // Adicionar ID de correlação no header de resposta
        response.setHeader("X-Correlation-ID", correlationId);
        
        return true;
    }
    
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        logger.info("Finalizando processamento de requisição: {} {} - Status: {}", 
                request.getMethod(), 
                request.getRequestURI(),
                response.getStatus());
        
        // Limpar o MDC após o processamento completo
        MDC.clear();
    }
}
