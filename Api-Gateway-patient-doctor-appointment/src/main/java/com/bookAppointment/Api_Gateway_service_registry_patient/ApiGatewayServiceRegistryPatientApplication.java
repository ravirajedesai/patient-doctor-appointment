package com.bookAppointment.Api_Gateway_service_registry_patient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ApiGatewayServiceRegistryPatientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayServiceRegistryPatientApplication.class, args);
	}

}
