package com.openclassrooms.mediscreenPatientAssessment.unit;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.openclassrooms.mediscreenPatientAssessment.model.PatientAssessment;
import com.openclassrooms.mediscreenPatientAssessment.service.PatientAssessmentService;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class PatientAssessmentServiceTest {

	@Autowired
	private PatientAssessmentService patientAssessmentService;

	@Test
	@DisplayName("Test assessement for age >= 30 and count of trigger words = 1, should be equal to None")
	public void evaluate_AgeMore30And1TriggerWords_ExpectNone() {

		PatientAssessmentService patientAssessementServiceMocked = Mockito.spy(patientAssessmentService);

		Mockito.doReturn(1).when(patientAssessementServiceMocked).countingTriggerWords(Mockito.any());

		PatientAssessment assessment = patientAssessementServiceMocked.calculatePatientAssessment(1);

		assertThat(assessment.getAssessmentResult()).isEqualTo("None");
	}

	@Test
	@DisplayName("Test assessement for age >= 30 and count of trigger words = 2, should be equal to Borderline")
	public void evaluate_AgeMore30And2TriggerWords_ExpectBorderline() {

		PatientAssessmentService patientAssessementServiceMocked = Mockito.spy(patientAssessmentService);

		Mockito.doReturn(2).when(patientAssessementServiceMocked).countingTriggerWords(Mockito.any());

		PatientAssessment assessment = patientAssessementServiceMocked.calculatePatientAssessment(1);

		assertThat(assessment.getAssessmentResult()).isEqualTo("Borderline");
	}

	@Test
	@DisplayName("Test assessement for age >= 30 and count of trigger words = 8, should be equal to In Danger")
	public void evaluate_AgeMore30And6TriggerWords_ExpectInDanger() {

		PatientAssessmentService patientAssessementServiceMocked = Mockito.spy(patientAssessmentService);

		Mockito.doReturn(6).when(patientAssessementServiceMocked).countingTriggerWords(Mockito.any());

		PatientAssessment assessment = patientAssessementServiceMocked.calculatePatientAssessment(1);

		assertThat(assessment.getAssessmentResult()).isEqualTo("In Danger");
	}

	@Test
	@DisplayName("Test assessement for age >= 30 and count of trigger words = 7, should be equal to Early onset")
	public void evaluate_AgeMore30And8TriggerWords_ExpectEarlyOnset() {

		PatientAssessmentService patientAssessementServiceMocked = Mockito.spy(patientAssessmentService);

		Mockito.doReturn(8).when(patientAssessementServiceMocked).countingTriggerWords(Mockito.any());

		PatientAssessment assessment = patientAssessementServiceMocked.calculatePatientAssessment(1);

		assertThat(assessment.getAssessmentResult()).isEqualTo("Early onset");
	}

	@Test
	@DisplayName("Test assessement for age <30, sexe = F and count of trigger words = 1, should be equal to None")
	public void evaluate_AgeLess30SexeFAnd1TriggerWords_ExpectNone() {

		PatientAssessmentService patientAssessementServiceMocked = Mockito.spy(patientAssessmentService);

		Mockito.doReturn(1).when(patientAssessementServiceMocked).countingTriggerWords(Mockito.any());

		PatientAssessment assessment = patientAssessementServiceMocked.calculatePatientAssessment(4);

		assertThat(assessment.getAssessmentResult()).isEqualTo("None");
	}

	@Test
	@DisplayName("Test assessement for age <30, sexe = F and count of trigger words = 5, should be equal to In Danger")
	public void evaluate_AgeLess30SexeFAnd5TriggerWords_ExpectInDanger() {

		PatientAssessmentService patientAssessementServiceMocked = Mockito.spy(patientAssessmentService);

		Mockito.doReturn(5).when(patientAssessementServiceMocked).countingTriggerWords(Mockito.any());

		PatientAssessment assessment = patientAssessementServiceMocked.calculatePatientAssessment(4);

		assertThat(assessment.getAssessmentResult()).isEqualTo("In Danger");
	}

	@Test
	@DisplayName("Test assessement for age <30, sexe = F and count of trigger words = 7, should be equal to Early onset")
	public void evaluate_AgeLess30SexeFAnd7TriggerWords_ExpectEarlyOnset() {

		PatientAssessmentService patientAssessementServiceMocked = Mockito.spy(patientAssessmentService);

		Mockito.doReturn(7).when(patientAssessementServiceMocked).countingTriggerWords(Mockito.any());

		PatientAssessment assessment = patientAssessementServiceMocked.calculatePatientAssessment(4);

		assertThat(assessment.getAssessmentResult()).isEqualTo("Early onset");
	}

	@Test
	@DisplayName("Test assessement for age <30, sexe = M and count of trigger words = 1, should be equal to None")
	public void evaluate_AgeLess30SexeMAnd1TriggerWords_ExpectNone() {

		PatientAssessmentService patientAssessementServiceMocked = Mockito.spy(patientAssessmentService);

		Mockito.doReturn(1).when(patientAssessementServiceMocked).countingTriggerWords(Mockito.any());

		PatientAssessment assessment = patientAssessementServiceMocked.calculatePatientAssessment(3);

		assertThat(assessment.getAssessmentResult()).isEqualTo("None");
	}

	@Test
	@DisplayName("Test assessement for age <30, sexe = M and count of trigger words = 3, should be equal to In Danger")
	public void evaluate_AgeLess30SexeMAnd5TriggerWords_ExpectInDanger() {

		PatientAssessmentService patientAssessementServiceMocked = Mockito.spy(patientAssessmentService);

		Mockito.doReturn(3).when(patientAssessementServiceMocked).countingTriggerWords(Mockito.any());

		PatientAssessment assessment = patientAssessementServiceMocked.calculatePatientAssessment(3);

		assertThat(assessment.getAssessmentResult()).isEqualTo("In Danger");
	}

	@Test
	@DisplayName("Test assessement for age <30, sexe = M and count of trigger words = 7, should be equal to Early onset")
	public void evaluate_AgeLess30SexeMAnd7TriggerWords_ExpectEarlyOnset() {

		PatientAssessmentService patientAssessementServiceMocked = Mockito.spy(patientAssessmentService);

		Mockito.doReturn(7).when(patientAssessementServiceMocked).countingTriggerWords(Mockito.any());

		PatientAssessment assessment = patientAssessementServiceMocked.calculatePatientAssessment(3);

		assertThat(assessment.getAssessmentResult()).isEqualTo("Early onset");
	}
}
