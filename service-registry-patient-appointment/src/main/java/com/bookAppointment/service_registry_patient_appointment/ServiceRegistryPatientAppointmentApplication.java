package com.bookAppointment.service_registry_patient_appointment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ServiceRegistryPatientAppointmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceRegistryPatientAppointmentApplication.class, args);
	}

}
