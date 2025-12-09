package com.patient_doctor_appointment.bill.feignClient;

import com.patient_doctor_appointment.bill.dto.AppointmentResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "APPOINTMENT-SERVICE")
public interface AppointmentClient {

    @GetMapping("/{id}")
    AppointmentResponse getAppointmentById(@PathVariable Long id);
}
