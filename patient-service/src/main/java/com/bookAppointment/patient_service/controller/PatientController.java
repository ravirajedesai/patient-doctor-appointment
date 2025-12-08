package com.bookAppointment.patient_service.controller;

import com.bookAppointment.patient_service.entity.Patient;
import com.bookAppointment.patient_service.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientController {
    @Autowired
    PatientService service;

    @GetMapping
    ResponseEntity<List<Patient>> getAllPatients(){
        List<Patient> allPatient=service.getAllPatient();
        return ResponseEntity.ok(allPatient);
    }
    @GetMapping("/{id}")
    ResponseEntity<Patient> getPatientById(@PathVariable Long id){
        Patient patientById=service.getPatientById(id);
        return ResponseEntity.ok(patientById);
    }
    @DeleteMapping("/{id}")
    ResponseEntity<Patient> deletePatientById(@PathVariable Long id){
        service.deletePatientById(id);
        return ResponseEntity.noContent().build();
    }
    @PostMapping
    ResponseEntity<Patient> addPatient(@RequestBody Patient patient){
        Patient newPatient=service.addPatient(patient);
        return new ResponseEntity<>(newPatient, HttpStatus.CREATED);
    }
}
