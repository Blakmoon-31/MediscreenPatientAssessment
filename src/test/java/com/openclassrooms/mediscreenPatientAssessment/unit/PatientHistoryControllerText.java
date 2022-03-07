package com.openclassrooms.mediscreenPatientAssessment.unit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.openclassrooms.mediscreenPatientAssessment.service.PatientAssessmentService;

@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
public class PatientHistoryControllerText {

	@Mock
	private static PatientAssessmentService patientAssessmentService;

	@Test
	public void testAssessmentNone() {

	}

}
