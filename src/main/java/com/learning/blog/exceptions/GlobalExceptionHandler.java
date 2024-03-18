package com.learning.blog.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.learning.blog.payloads.ApiResponse;

import io.jsonwebtoken.JwtException;


@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> resourceNotFoundException(ResourceNotFoundException e) {
        String msg = e.getMessage();
        return new ResponseEntity<>(new ApiResponse(msg,false),HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(JwtException.class)
    public ResponseEntity<ApiResponse> malformedJwtException(JwtException e) {
        String msg = e.getMessage();
        System.out.println("============================testtttt====================");
        return new ResponseEntity<>(new ApiResponse(msg,false),HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        Map<String,String> errors = new HashMap<>();
        e.getBindingResult().getAllErrors().forEach((err)->{
            
            String fieldName = ((FieldError)err).getField();
            String fieldMsg = err.getDefaultMessage();
            errors.put(fieldName, fieldMsg);
        });
        return new ResponseEntity<>(new ApiResponse("Validation error",false,errors),HttpStatus.BAD_REQUEST);
    }


}
