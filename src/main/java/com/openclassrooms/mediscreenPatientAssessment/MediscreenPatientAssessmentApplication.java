package com.openclassrooms.mediscreenPatientAssessment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableFeignClients("com.openclassrooms.mediscreenPatientAssessment")
@EnableSwagger2
public class MediscreenPatientAssessmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(MediscreenPatientAssessmentApplication.class, args);
	}

}
