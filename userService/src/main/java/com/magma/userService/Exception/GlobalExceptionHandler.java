package com.magma.userService.Exception;

import com.magma.userService.Payload.Response.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ExceptionResponse> ExceptionHandler(
            Exception ex, WebRequest req
    ){
        ExceptionResponse res=new ExceptionResponse(
                ex.getMessage(),
                req.getDescription(false),
                LocalDateTime.now()
        );
        return ResponseEntity.ok(res);
    }

    @ExceptionHandler(UserException.class)
    public ResponseEntity<ExceptionResponse> UserExceptionHandler(
            Exception ex, WebRequest req
    ){
        ExceptionResponse res=new ExceptionResponse(
                ex.getMessage(),
                req.getDescription(false),
                LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(res);
    }
}
