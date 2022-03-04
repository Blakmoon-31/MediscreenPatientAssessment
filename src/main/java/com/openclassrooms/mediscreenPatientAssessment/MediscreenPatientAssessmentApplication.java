package com.openclassrooms.mediscreenPatientAssessment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("com.openclassrooms.mediscreenPatientAssessment")
public class MediscreenPatientAssessmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(MediscreenPatientAssessmentApplication.class, args);
	}

}
