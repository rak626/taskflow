package com.rakesh.taskflow.exception;

import com.rakesh.taskflow.model.Response;
import com.rakesh.taskflow.util.ResponseUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(AuthorizationException.class)
    public ResponseEntity<Response<?>> handleAuthorizationException(AuthorizationException ex) {
        return ResponseUtil.prepareErrorResponse(HttpStatus.UNAUTHORIZED, ex, ex.getMessage());
    }

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<Response<?>> handleValidationException(ValidationException ex) {
        return ResponseUtil.prepareErrorResponse(HttpStatus.BAD_REQUEST, ex, ex.getMessage());
    }

    @ExceptionHandler(NoDataFoundException.class)
    public ResponseEntity<Response<?>> handleNoDataFoundException(NoDataFoundException ex) {
        return ResponseUtil.prepareErrorResponse(HttpStatus.NOT_FOUND, ex, ex.getMessage());
    }

    @ExceptionHandler(PlatformException.class)
    public ResponseEntity<Response<?>> handlePlatformException(PlatformException ex) {
        return ResponseUtil.prepareErrorResponse(HttpStatus.BAD_GATEWAY, ex, ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Response<?>> handleGenericException(Exception ex) {
        return ResponseUtil.prepareErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, ex, ex.getMessage());
    }
}
