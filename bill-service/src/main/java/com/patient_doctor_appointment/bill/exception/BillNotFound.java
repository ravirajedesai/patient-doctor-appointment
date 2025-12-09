package com.patient_doctor_appointment.bill.exception;

public class BillNotFound extends RuntimeException{
    public BillNotFound(String message) {
        super(message);
    }
}
