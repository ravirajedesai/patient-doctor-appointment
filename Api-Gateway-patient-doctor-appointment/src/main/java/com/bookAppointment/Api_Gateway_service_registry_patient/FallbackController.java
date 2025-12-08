package com.bookAppointment.Api_Gateway_service_registry_patient;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackController {

    @GetMapping("/patientFallback")
    public String patientFallback(){
        return "Patient Service is Down..";
    }
    @GetMapping("/doctorFallback")
    public String doctorFallback(){
        return "Doctor Service is Down..";
    }
    @GetMapping("/appointmentFallback")
    public String appointmentFallback(){
        return "Appointment Service is Down..";
    }
}
