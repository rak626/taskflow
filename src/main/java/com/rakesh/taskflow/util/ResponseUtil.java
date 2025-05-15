package com.rakesh.taskflow.util;

import com.rakesh.taskflow.model.Response;
import com.rakesh.taskflow.util.enums.Status;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Slf4j
public class ResponseUtil {

    public static <T> ResponseEntity<Response<T>> prepareResponse(T result) {
        Response<T> response = new Response<>();
        response.setStatus(Status.SUCCESS);
        response.setResult(result);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    // need to be more logical
    // based on each exception logic will be different
    public static ResponseEntity<Response<?>> prepareErrorResponse(HttpStatus httpStatus, Exception ex, String message) {
        Response<?> response = new Response<>();
        response.setStatus(Status.ERROR);
        response.getErrors().add(new Error(message));
        log.error("Error occurred: {}", message, ex);
        return ResponseEntity.status(httpStatus).body(response);
    }
}
