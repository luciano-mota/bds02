package com.devsuperior.bds02.exceptions.handler;

import com.devsuperior.bds02.exceptions.IsDataBaseExcetion;
import com.devsuperior.bds02.exceptions.IsNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(IsNotFoundException.class)
    public ResponseEntity<StandartError> entityNotFound(IsNotFoundException isNotFoundException, HttpServletRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandartError error = new StandartError();
        error.setStatus(status.value());
        error.setError("Is not found");
        error.setMessage(isNotFoundException.getMessage());
        error.setPath(request.getRequestURI());

        return ResponseEntity.status(status).body(error);
    }

    @ExceptionHandler(IsDataBaseExcetion.class)
    public ResponseEntity<StandartError> dataBaseException(IsDataBaseExcetion isDataBaseExcetion, HttpServletRequest request) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandartError error = new StandartError();
        error.setStatus(status.value());
        error.setError("Database exception");
        error.setMessage(isDataBaseExcetion.getMessage());
        error.setPath(request.getRequestURI());

        return ResponseEntity.status(status).body(error);
    }
}