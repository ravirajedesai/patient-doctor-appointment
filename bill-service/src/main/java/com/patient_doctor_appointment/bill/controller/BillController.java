package com.patient_doctor_appointment.bill.controller;

import com.patient_doctor_appointment.bill.dto.AppointmentResponse;
import com.patient_doctor_appointment.bill.entity.Bill;
import com.patient_doctor_appointment.bill.feignClient.AppointmentClient;
import com.patient_doctor_appointment.bill.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bill")
public class BillController {

    @Autowired
    BillService service;

    @GetMapping("/generate/{id}")
    public ResponseEntity<Bill> generateBillFromAppointmentId(@PathVariable Long id){
       Bill bill=service.generateBillFromAppointment(id);
        return ResponseEntity.status(HttpStatus.CREATED).body(bill);
    }
    @PostMapping
    ResponseEntity<Bill> createBill(@RequestBody Bill bill){
        Bill createdBill=service.createBill(bill);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdBill);
    }
    @GetMapping
    ResponseEntity<List<Bill>> getAllBill(){
        List<Bill>all=service.getAllBills();
        return ResponseEntity.status(HttpStatus.OK).body(all);
    }
    @GetMapping("/{id}")
    ResponseEntity<Bill> getBillById(@PathVariable Long id){
        Bill billById=service.getBillById(id);
        return ResponseEntity.status(HttpStatus.OK).body(billById);
    }
    @DeleteMapping("/{id}")
    public  ResponseEntity<Void> deleteBillById(@PathVariable Long id){
        service.deleteBillById(id);
        return ResponseEntity.noContent().build();
    }
}
