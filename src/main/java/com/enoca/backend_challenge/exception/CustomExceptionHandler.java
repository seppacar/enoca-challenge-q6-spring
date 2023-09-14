package com.enoca.backend_challenge.exception;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(DuplicateResourceException.class)
    public ResponseEntity<String> handleDuplicateResourceException(DuplicateResourceException ex) {
        // Return a response with HTTP status 409 (Conflict)
        return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<String> handleResourceNotFoundException(ResourceNotFoundException ex) {
        // Return a response with HTTP status 404 (Not Found)
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(ResourceUpdateFailedException.class)
    public ResponseEntity<String> handleResourceNotFoundException(ResourceUpdateFailedException ex) {
        // Return a response with HTTP status 405 (Conflict)
        return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
    }
}
