package com.patient_doctor_appointment.bill.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentResponse {
    private Long appointmentId;
    private Long patientId;
    private Long doctorId;
    @Column(nullable = false)
    private Double doctorFee;

}
