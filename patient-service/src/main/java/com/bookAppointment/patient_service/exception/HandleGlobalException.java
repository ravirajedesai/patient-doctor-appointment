package com.bookAppointment.patient_service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class HandleGlobalException {

    @ExceptionHandler(PatientNotFound.class)
    public ResponseEntity<String> PatientNotFound(PatientNotFound ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
