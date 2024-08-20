package joelf.tech.rinha.exceptions.handlers;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.servlet.http.HttpServletRequest;
import joelf.tech.rinha.exceptions.BusinessRuleException;
import joelf.tech.rinha.exceptions.ResourceNotFoundException;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ResponseException> handleNotFound(HttpServletRequest request, ResourceNotFoundException ex) {
        var status = HttpStatus.NOT_FOUND;

        return ResponseEntity.status(status)
                .body(new ResponseException(Instant.now(), status.value(), ex.getMessage(), request.getRequestURI()));
    }

    @ExceptionHandler(BusinessRuleException.class)
    public ResponseEntity<ResponseException> handleDatabase(HttpServletRequest request,
            BusinessRuleException ex) {
        var status = HttpStatus.BAD_REQUEST;

        return ResponseEntity.status(status)
                .body(new ResponseException(Instant.now(), status.value(), ex.getMessage(), request.getRequestURI()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationException> handleArgumentNotValid(HttpServletRequest request,
            MethodArgumentNotValidException ex) {

        var status = HttpStatus.UNPROCESSABLE_ENTITY;
        var exception = new ValidationException(Instant.now(), status.value(), "Invalid data.",
                request.getRequestURI());

        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            exception.addError(error.getField(), error.getDefaultMessage());
        }

        return ResponseEntity.status(status).body(exception);
    }
}