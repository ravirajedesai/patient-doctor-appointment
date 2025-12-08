package com.bookAppointment.patient_service.service;

import com.bookAppointment.patient_service.entity.Patient;

import java.util.List;

public interface PatientService {
    List<Patient> getAllPatient();
    Patient getPatientById(Long id);
    void deletePatientById(Long id);
    Patient addPatient(Patient patient);
}
