package com.bookAppointment.appointment_service.service;

import com.bookAppointment.appointment_service.dto.DoctorDto;
import com.bookAppointment.appointment_service.dto.PatientDto;
import com.bookAppointment.appointment_service.entity.Appointment;
import com.bookAppointment.appointment_service.feign.DoctorClient;
import com.bookAppointment.appointment_service.feign.PatientClient;
import com.bookAppointment.appointment_service.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService{

    @Autowired
    AppointmentRepository repository;

    @Autowired
    DoctorClient doctorClient;

    @Autowired
    PatientClient patientClient;

    @Override
    public Appointment bookAppointment(Appointment appointment) {
        return repository.save(appointment);
    }
    @Override
    public List<Appointment> getAllAppointments() {
        return repository.findAll();
    }
    @Override
    public Appointment getAppointmentById(Long id) {
        return repository.findById(id)
                .orElseThrow(()->
                        new RuntimeException("Appointment Not Found."));
    }
    @Override
    public void deleteAppointmentById(Long id) {
        repository.deleteById(id);
    }
    @Override
    public PatientDto getPatientById(Long id) {
        return patientClient.getPatientById(id);
    }
    @Override
    public DoctorDto getDoctorById(Long id) {
        return doctorClient.getDoctorById(id);
    }

}
