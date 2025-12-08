package com.bookAppointment.appointment_service.repository;

import com.bookAppointment.appointment_service.dto.DoctorDto;
import com.bookAppointment.appointment_service.dto.PatientDto;
import com.bookAppointment.appointment_service.entity.Appointment;
import com.bookAppointment.appointment_service.feign.DoctorClient;
import com.bookAppointment.appointment_service.feign.PatientClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment,Long> {

}
