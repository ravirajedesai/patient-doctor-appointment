package com.patient_doctor_appointment.bill.service;

import com.patient_doctor_appointment.bill.dto.AppointmentResponse;
import com.patient_doctor_appointment.bill.entity.Bill;

import java.util.List;

public interface BillService {
    List<Bill> getAllBills();
    Bill getBillById(Long id);
    void deleteBillById(Long id);
    Bill createBill(Bill bill);

    Bill generateBillFromAppointment(Long appointmentId);
}
