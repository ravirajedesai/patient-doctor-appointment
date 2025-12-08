package com.bookAppointment.appointment_service.dto;

import com.bookAppointment.appointment_service.entity.Appointment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentDto {
     private Appointment appointment;
     private DoctorDto doctorDto;
     private PatientDto patientDto;
}
