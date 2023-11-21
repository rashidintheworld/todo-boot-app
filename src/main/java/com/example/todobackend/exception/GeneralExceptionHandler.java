package com.example.todobackend.exception;

import com.example.todobackend.model.dto.respond.RespStatus;
import com.example.todobackend.model.dto.respond.Response;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GeneralExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public Response handleException(ResourceNotFoundException resourceNotFoundException) {
        Response response = new Response();
        response.setRespStatus(new RespStatus(HttpStatus.NOT_FOUND.value(), "Resource not found!"));
        return response;
    }

    @ExceptionHandler(Exception.class)
    public Response handleException(Exception exception) {
        Response response = new Response();
        response.setRespStatus(new RespStatus(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Internal server exception"));
        return response;
    }
}
