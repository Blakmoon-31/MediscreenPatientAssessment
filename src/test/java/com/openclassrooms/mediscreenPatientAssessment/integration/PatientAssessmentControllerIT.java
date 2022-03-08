package com.openclassrooms.mediscreenPatientAssessment.integration;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.openclassrooms.mediscreenPatientAssessment.controller.PatientAssessmentController;
import com.openclassrooms.mediscreenPatientAssessment.model.PatientAssessment;

@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
public class PatientAssessmentControllerIT {

	@Autowired
	private PatientAssessmentController patientAssessmentController;

	@Test
	public void testCalculateAssessmentByPatientId() {

		PatientAssessment assessment = patientAssessmentController.calculatePatientAssessmentByPatientId(3);

		assertThat(assessment.getAssessmentResult()).isEqualTo("In Danger");
	}

	@Test
	public void testCalculateAssessmentByPatientName() {

		PatientAssessment assessment = patientAssessmentController
				.calculatePatientAssessmentByPatientName("TestEarlyOnset", "Test");

		assertThat(assessment.getAssessmentResult()).isEqualTo("Early onset");
	}
}
