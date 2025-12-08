package com.bookAppointment.doctor_service.service;

import com.bookAppointment.doctor_service.entity.Doctor;

import java.util.List;

public interface DoctorService {
    List<Doctor> getAllDoctors();
    Doctor getDoctorById(Long id);
    void deleteDoctorById(Long id);
    Doctor addDoctor(Doctor doctor);
}
