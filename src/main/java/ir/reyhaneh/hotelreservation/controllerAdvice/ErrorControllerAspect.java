package ir.reyhaneh.hotelreservation.controllerAdvice;

import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Aspect
@Component
@RequiredArgsConstructor
public class ErrorControllerAspect {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Around("within(ir.reyhaneh.hotelreservation.controller.*Controller)")
    public Object handleExceptions(ProceedingJoinPoint joinPoint) throws Throwable {
        try {
            return joinPoint.proceed();
        } catch (MethodArgumentNotValidException ex) {
            log.error("Validation error in {} - {}",
                    joinPoint.getSignature().getName(),
                    ex.getMessage()
            );

            Map<String, String> errors = ex.getBindingResult()
                    .getFieldErrors()
                    .stream()
                    .collect(Collectors.toMap(
                            FieldError::getField,
                            error -> error.getDefaultMessage() != null ? error.getDefaultMessage() : "Invalid value"
                    ));

            Map<String, Object> response = new HashMap<>();
            response.put("status", "ERROR");
            response.put("code", HttpStatus.BAD_REQUEST.value());
            response.put("message", "Validation failed");
            response.put("errors", errors);

            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);

        } catch (IllegalArgumentException ex) {
            log.error("Invalid argument in {} - {}",
                    joinPoint.getSignature().getName(),
                    ex.getMessage()
            );

            Map<String, Object> response = new HashMap<>();
            response.put("status", "ERROR");
            response.put("code", HttpStatus.BAD_REQUEST.value());
            response.put("message", ex.getMessage());

            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);

        } catch (Exception ex) {
            log.error("Unexpected error in {} - {}",
                    joinPoint.getSignature().getName(),
                    ex.getMessage(),
                    ex
            );

            Map<String, Object> response = new HashMap<>();
            response.put("status", "ERROR");
            response.put("code", HttpStatus.INTERNAL_SERVER_ERROR.value());
            response.put("message", "An unexpected error occurred");

            if (log.isDebugEnabled()) {
                response.put("debug_message", ex.getMessage());
            }

            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
