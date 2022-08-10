package com.pubsub.producer.errorhandler;

import java.util.ArrayList;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandler {

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<List<Violation>> onMethodArgumentNotValidException(
      final MethodArgumentNotValidException exception) {
    final var fieldErrors = new ArrayList<Violation>();
    for (final FieldError fieldError : exception.getBindingResult().getFieldErrors()) {
      fieldErrors.add(new Violation(fieldError.getField(), fieldError.getDefaultMessage()));
    }
    return ResponseEntity.badRequest().body(fieldErrors);
  }
}
