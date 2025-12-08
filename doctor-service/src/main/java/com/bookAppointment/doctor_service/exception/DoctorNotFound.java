package com.bookAppointment.doctor_service.exception;

public class DoctorNotFound extends RuntimeException{
    public DoctorNotFound(String message) {
        super(message);
    }
}
