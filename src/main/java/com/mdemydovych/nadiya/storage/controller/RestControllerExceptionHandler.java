package com.mdemydovych.nadiya.storage.controller;

import com.mdemydovych.nadiya.storage.examination.core.exception.ExaminationNotFoundException;
import java.nio.file.AccessDeniedException;
import java.nio.file.attribute.UserPrincipalNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class RestControllerExceptionHandler {

  @ExceptionHandler(value = UserPrincipalNotFoundException.class)
  @ResponseStatus(value = HttpStatus.NOT_FOUND)
  public ResponseEntity<String> userNotFoundException(UserPrincipalNotFoundException exception) {
    return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(value = ExaminationNotFoundException.class)
  @ResponseStatus(value = HttpStatus.NOT_FOUND)
  public ResponseEntity<String> examNotFoundException(ExaminationNotFoundException exception) {
    return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(value = AccessDeniedException.class)
  @ResponseStatus(value = HttpStatus.FORBIDDEN)
  public ResponseEntity<Object> userHasNoPermission(AccessDeniedException exception) {
    return new ResponseEntity<>(exception.getMessage(), HttpStatus.FORBIDDEN);
  }
}
