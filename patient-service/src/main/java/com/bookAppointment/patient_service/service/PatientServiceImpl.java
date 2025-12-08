package com.bookAppointment.patient_service.service;

import com.bookAppointment.patient_service.entity.Patient;
import com.bookAppointment.patient_service.exception.PatientNotFound;
import com.bookAppointment.patient_service.repository.PatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService{

    @Autowired
    PatientRepo repo;

    @Override
    public List<Patient> getAllPatient() {
        List<Patient> allpatient=repo.findAll();
        return allpatient;
    }
    @Override
    public Patient getPatientById(Long id) {
        Patient patientId=repo.findById(id)
                .orElseThrow(()->
                        new PatientNotFound("Patient Not Found.."));
        return patientId;
    }
    @Override
    public void deletePatientById(Long id) {
        repo.deleteById(id);
    }
    @Override
    public Patient addPatient(Patient patient) {
        Patient addPatient=repo.save(patient);
        return addPatient;
    }
}
