package com.example.teste.controller.exceptions;

import com.example.teste.services.exceptions.DataIntegrityViolationException;
import com.example.teste.services.exceptions.MethodArgumentNotValidException;
import com.example.teste.services.exceptions.ObjectnotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(ObjectnotFoundException.class)
    public ResponseEntity<StandardError> objectnotFoundException (ObjectnotFoundException ex, HttpServletRequest request){

        StandardError error = new StandardError(System.currentTimeMillis(),
                HttpStatus.NOT_FOUND.value(), "Objeto não encontrado!", ex.getMessage(), request.getRequestURI());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<StandardError> dataIntegrityViolationException (DataIntegrityViolationException ex, HttpServletRequest request){

        StandardError error = new StandardError(System.currentTimeMillis(),
                HttpStatus.BAD_REQUEST.value(), "Violação de Dados!", ex.getMessage(), request.getRequestURI());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StandardError> methodArgumentNotValidException (MethodArgumentNotValidException ex, HttpServletRequest request){

        StandardError error = new StandardError(System.currentTimeMillis(),
                HttpStatus.BAD_REQUEST.value(), "Argumento inválido!", ex.getMessage(), request.getRequestURI());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
}
