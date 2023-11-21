package com.example.todobackend.exception;

import com.example.todobackend.model.dto.respond.RespStatus;
import com.example.todobackend.model.dto.respond.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.Timestamp;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GeneralExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleException(ResourceNotFoundException resourceNotFoundException) {
        ErrorResponse response = new ErrorResponse();
        response.setStatusCode(HttpStatus.NOT_FOUND.value());
        response.setMessage(resourceNotFoundException.getMessage());
        response.setTimestamp(System.currentTimeMillis());
        return new ResponseEntity<ErrorResponse>(response,HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> methodArgumentNotValidException(MethodArgumentNotValidException methodArgumentNotValidException){
        ErrorResponse response = new ErrorResponse();
        response.setStatusCode(HttpStatus.BAD_REQUEST.value());
        response.setMessage(methodArgumentNotValidException.getBindingResult().getFieldErrors().stream().map(x -> x.getDefaultMessage()).collect(Collectors.joining(",")));
        response.setTimestamp(System.currentTimeMillis());
        return new ResponseEntity<ErrorResponse>(response,HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(Exception exception) {
        ErrorResponse response = new ErrorResponse();
        response.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        response.setMessage(exception.getMessage());
        response.setTimestamp(System.currentTimeMillis());
        return new ResponseEntity<ErrorResponse>(response,HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
