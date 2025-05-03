package com.rakesh.taskflow.util;

import com.rakesh.taskflow.model.Response;
import com.rakesh.taskflow.util.enums.Status;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseUtil {

    public static <T> ResponseEntity<Response<T>> prepareResponse(T result) {
        Response<T> response = new Response<>();
        response.setStatus(Status.SUCCESS);
        response.setResult(result);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    // need to be more logical
    // based on each exception logic will be different
    public static ResponseEntity<Response<?>> prepareErrorResponse(HttpStatus httpStatus, String message) {
        Response<?> response = new Response<>();
        response.setStatus(Status.ERROR);
        response.getErrors().add(new Error(message));
        return ResponseEntity.status(httpStatus).body(response);
    }
}
