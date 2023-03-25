package com.example.Employe.customException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class GobalExceptionHandler extends ResponseEntityExceptionHandler {

        @ExceptionHandler(InternalServerErrorException.class)
        public ResponseEntity<Object> BadRequestException(InternalServerErrorException ex, WebRequest request) {
            String errorMessage = "An error occurred: " + ex.getMessage();
            return handleExceptionInternal(ex, errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
        }




}
