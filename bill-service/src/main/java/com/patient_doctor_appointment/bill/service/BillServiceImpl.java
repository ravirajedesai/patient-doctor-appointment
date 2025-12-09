package com.patient_doctor_appointment.bill.service;

import com.patient_doctor_appointment.bill.dto.AppointmentResponse;
import com.patient_doctor_appointment.bill.entity.Bill;
import com.patient_doctor_appointment.bill.exception.BillNotFound;
import com.patient_doctor_appointment.bill.feignClient.AppointmentClient;
import com.patient_doctor_appointment.bill.repo.BillRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BillServiceImpl implements BillService{

    @Autowired
    BillRepo repo;

    @Autowired
    AppointmentClient appointmentClient;

    public AppointmentResponse getAppointmentById(Long id) {
        return appointmentClient.getAppointmentById(id);
    }
    @Override
    public List<Bill> getAllBills() {
        return repo.findAll();
    }
    @Override
    public Bill getBillById(Long id) {
        return repo.findById(id)
                .orElseThrow(()-> new BillNotFound("Bill Not Found.."));
    }
    @Override
    public void deleteBillById(Long id) {
        repo.deleteById(id);
    }
    @Override
    public Bill createBill(Bill bill) {
        if(bill.getAppointmentId()==null){
            throw new RuntimeException("Appointment Id Not Found");
        }
        AppointmentResponse response=appointmentClient.getAppointmentById(bill.getAppointmentId());

        if (response == null) {
            throw new RuntimeException("Appointment not found with id: " + bill.getAppointmentId());
        }
        if (response.getDoctorFee() == null) {
            throw new RuntimeException("Doctor fee is null for appointment id: " + bill.getAppointmentId());
        }
        bill.setPatientId(response.getPatientId());
        bill.setDoctorId(response.getDoctorId());
        //bill.setDoctorFee(response.getDoctorFee());
        bill.setCreatedAt(LocalDateTime.now());
        return repo.save(bill);
    }
    public Bill generateBillFromAppointment(Long appointmentId){
        AppointmentResponse response=appointmentClient.getAppointmentById(appointmentId);
        Bill bill= new Bill();
        bill.setAppointmentId(response.getAppointmentId());
        bill.setPatientId(response.getPatientId());
        bill.setDoctorId(response.getDoctorId());
        //bill.setDoctorFee(response.getDoctorFee());
        bill.setCreatedAt(LocalDateTime.now());
        return repo.save(bill);
    }


}
