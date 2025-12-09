package com.patient_doctor_appointment.bill.repo;

import com.patient_doctor_appointment.bill.dto.AppointmentResponse;
import com.patient_doctor_appointment.bill.entity.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillRepo extends JpaRepository<Bill,Long> {

}
