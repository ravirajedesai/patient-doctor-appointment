package com.bookAppointment.appointment_service.service;

import com.bookAppointment.appointment_service.dto.DoctorDto;
import com.bookAppointment.appointment_service.dto.PatientDto;
import com.bookAppointment.appointment_service.entity.Appointment;

import java.util.List;

public interface AppointmentService {
    Appointment bookAppointment(Appointment appointment);
    List<Appointment> getAllAppointments();
    Appointment getAppointmentById(Long id);
    void deleteAppointmentById(Long id);

    PatientDto getPatientById(Long id);
    DoctorDto getDoctorById(Long id);

}
