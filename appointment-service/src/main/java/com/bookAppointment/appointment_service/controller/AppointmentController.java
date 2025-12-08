package com.bookAppointment.appointment_service.controller;

import com.bookAppointment.appointment_service.dto.AppointmentDto;
import com.bookAppointment.appointment_service.dto.DoctorDto;
import com.bookAppointment.appointment_service.dto.PatientDto;
import com.bookAppointment.appointment_service.entity.Appointment;
import com.bookAppointment.appointment_service.feign.DoctorClient;
import com.bookAppointment.appointment_service.feign.PatientClient;
import com.bookAppointment.appointment_service.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

    @Autowired
    AppointmentService service;

    @Autowired
    DoctorClient doctorClient;

    @Autowired
    PatientClient patientClient;

    @GetMapping
    public ResponseEntity<List<Appointment>> getAllAppointments(){
        return ResponseEntity.ok(service.getAllAppointments());
    }
    @PostMapping
    public ResponseEntity<AppointmentDto> createAppointment(@RequestBody Appointment appointment){

        PatientDto patient=patientClient.getPatientById(appointment.getPatientId());
        DoctorDto doctor=doctorClient.getDoctorById(appointment.getDoctorId());

        appointment.setDoctorFee(doctor.getDoctorFee());

        Appointment saved=service.bookAppointment(appointment);

        AppointmentDto appointmentDto=new AppointmentDto();
        appointmentDto.setAppointment(saved);
        appointmentDto.setDoctorDto(doctor);
        appointmentDto.setPatientDto(patient);

        return ResponseEntity.status(HttpStatus.CREATED).body(appointmentDto);
    }
    @GetMapping("/{id}")
    public ResponseEntity<AppointmentDto> getAppointmentById(@PathVariable Long id){
        Appointment appointment=service.getAppointmentById(id);
        PatientDto patient=patientClient.getPatientById(appointment.getPatientId());
        DoctorDto doctor=doctorClient.getDoctorById(appointment.getDoctorId());

        AppointmentDto dto=new AppointmentDto();
        dto.setAppointment(appointment);
        dto.setPatientDto(patient);
        dto.setDoctorDto(doctor);
        return ResponseEntity.ok(dto);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAppointmentById(@PathVariable Long id){
        service.deleteAppointmentById(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/patient/{id}")
    public PatientDto getPatientById(@PathVariable Long id){
        return patientClient.getPatientById(id);
    }
    @GetMapping("/doctor/{id}")
    public DoctorDto getDoctorById(@PathVariable Long id){
        return doctorClient.getDoctorById(id);
    }
}
