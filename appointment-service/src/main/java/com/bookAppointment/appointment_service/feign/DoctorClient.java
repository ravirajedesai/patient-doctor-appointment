package com.bookAppointment.appointment_service.feign;

import com.bookAppointment.appointment_service.dto.DoctorDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "DOCTOR-SERVICE",url = "http://localhost:8081")
public interface DoctorClient {

    @GetMapping("/doctor/{id}")
    DoctorDto getDoctorById(@PathVariable Long id);
}
