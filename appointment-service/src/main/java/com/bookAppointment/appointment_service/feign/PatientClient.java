package com.bookAppointment.appointment_service.feign;

import com.bookAppointment.appointment_service.dto.PatientDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "PATIENT-SERVICE",url = "http://localhost:8080")
public interface PatientClient {

    @GetMapping("/patient/{id}")
    PatientDto getPatientById(@PathVariable Long id);
}
