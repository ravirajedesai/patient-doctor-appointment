package com.bookAppointment.appointment_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientDto {
    private Long patientId;
    private String patientName;
    private String patientGender;
    private String patientDisease;
    private String contactNumber;
}
