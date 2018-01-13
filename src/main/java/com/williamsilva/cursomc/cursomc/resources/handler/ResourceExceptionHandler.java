package com.williamsilva.cursomc.cursomc.resources.handler;

import com.williamsilva.cursomc.cursomc.services.exception.ObjetoNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ObjetoNotFoundException.class)
    public ResponseEntity<StandardError> objetoNotFoundException(ObjetoNotFoundException e, HttpServletRequest request) {
        StandardError standardError = new StandardError(HttpStatus.NOT_FOUND.value(), e.getMessage(), LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(standardError);
//        return ResponseEntity.notFound().build();
    }
}
