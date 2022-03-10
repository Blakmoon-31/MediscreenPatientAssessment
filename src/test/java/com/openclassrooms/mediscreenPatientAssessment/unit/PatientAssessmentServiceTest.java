package com.openclassrooms.mediscreenPatientAssessment.unit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.openclassrooms.mediscreenPatientAssessment.bean.PatientBean;
import com.openclassrooms.mediscreenPatientAssessment.bean.PatientHistoryBean;
import com.openclassrooms.mediscreenPatientAssessment.model.PatientAssessment;
import com.openclassrooms.mediscreenPatientAssessment.proxy.PatientHistoryProxy;
import com.openclassrooms.mediscreenPatientAssessment.proxy.PatientProxy;
import com.openclassrooms.mediscreenPatientAssessment.service.PatientAssessmentService;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
@TestInstance(Lifecycle.PER_CLASS)
public class PatientAssessmentServiceTest {

	@Autowired
	@InjectMocks
	private PatientAssessmentService patientAssessmentService;

	@Mock
	PatientProxy patientProxy;

	@Mock
	PatientHistoryProxy patientHistoryProxy;

	@BeforeAll
	private void setTestData() {
		List<PatientHistoryBean> patientHistoryBeans = new ArrayList<>();
		when(patientHistoryProxy.getPatientHistoriesByPatientId(anyInt())).thenReturn(patientHistoryBeans);
	}

	@Test
	@DisplayName("Test assessement for age >= 30 and count of trigger words = 1, should be equal to None")
	public void evaluate_AgeMore30And1TriggerWords_ExpectNone() {

		PatientBean patientBean = new PatientBean();
		patientBean.setPatientId(1);
		patientBean.setBirthdate(LocalDate.of(1980, 01, 01));

		when(patientProxy.getPatientById(1)).thenReturn(patientBean);

		PatientAssessmentService patientAssessementServiceMocked = Mockito.spy(patientAssessmentService);

		Mockito.doReturn(1).when(patientAssessementServiceMocked).countingTriggerWords(Mockito.any());

		PatientAssessment assessment = patientAssessementServiceMocked.calculatePatientAssessment(1);

		assertThat(assessment.getAssessmentResult()).isEqualTo("None");
	}

	@Test
	@DisplayName("Test assessement for age >= 30 and count of trigger words = 2, should be equal to Borderline")
	public void evaluate_AgeMore30And2TriggerWords_ExpectBorderline() {

		PatientBean patientBean = new PatientBean();
		patientBean.setPatientId(1);
		patientBean.setBirthdate(LocalDate.of(1980, 01, 01));

		when(patientProxy.getPatientById(1)).thenReturn(patientBean);

		PatientAssessmentService patientAssessementServiceMocked = Mockito.spy(patientAssessmentService);

		Mockito.doReturn(2).when(patientAssessementServiceMocked).countingTriggerWords(Mockito.any());

		PatientAssessment assessment = patientAssessementServiceMocked.calculatePatientAssessment(1);

		assertThat(assessment.getAssessmentResult()).isEqualTo("Borderline");
	}

	@Test
	@DisplayName("Test assessement for age >= 30 and count of trigger words = 8, should be equal to In Danger")
	public void evaluate_AgeMore30And6TriggerWords_ExpectInDanger() {

		PatientBean patientBean = new PatientBean();
		patientBean.setPatientId(1);
		patientBean.setBirthdate(LocalDate.of(1980, 01, 01));

		when(patientProxy.getPatientById(1)).thenReturn(patientBean);

		PatientAssessmentService patientAssessementServiceMocked = Mockito.spy(patientAssessmentService);

		Mockito.doReturn(6).when(patientAssessementServiceMocked).countingTriggerWords(Mockito.any());

		PatientAssessment assessment = patientAssessementServiceMocked.calculatePatientAssessment(1);

		assertThat(assessment.getAssessmentResult()).isEqualTo("In Danger");
	}

	@Test
	@DisplayName("Test assessement for age >= 30 and count of trigger words = 7, should be equal to Early onset")
	public void evaluate_AgeMore30And8TriggerWords_ExpectEarlyOnset() {

		PatientBean patientBean = new PatientBean();
		patientBean.setPatientId(1);
		patientBean.setBirthdate(LocalDate.of(1980, 01, 01));

		when(patientProxy.getPatientById(1)).thenReturn(patientBean);

		PatientAssessmentService patientAssessementServiceMocked = Mockito.spy(patientAssessmentService);

		Mockito.doReturn(8).when(patientAssessementServiceMocked).countingTriggerWords(Mockito.any());

		PatientAssessment assessment = patientAssessementServiceMocked.calculatePatientAssessment(1);

		assertThat(assessment.getAssessmentResult()).isEqualTo("Early onset");
	}

	@Test
	@DisplayName("Test assessement for age <30, sexe = F and count of trigger words = 1, should be equal to None")
	public void evaluate_AgeLess30SexeFAnd1TriggerWords_ExpectNone() {

		PatientBean patientBean = new PatientBean();
		patientBean.setPatientId(1);
		patientBean.setSex("F");
		patientBean.setBirthdate(LocalDate.of(2000, 01, 01));

		when(patientProxy.getPatientById(1)).thenReturn(patientBean);

		PatientAssessmentService patientAssessementServiceMocked = Mockito.spy(patientAssessmentService);

		Mockito.doReturn(1).when(patientAssessementServiceMocked).countingTriggerWords(Mockito.any());

		PatientAssessment assessment = patientAssessementServiceMocked.calculatePatientAssessment(1);

		assertThat(assessment.getAssessmentResult()).isEqualTo("None");
	}

	@Test
	@DisplayName("Test assessement for age <30, sexe = F and count of trigger words = 5, should be equal to In Danger")
	public void evaluate_AgeLess30SexeFAnd5TriggerWords_ExpectInDanger() {

		PatientBean patientBean = new PatientBean();
		patientBean.setPatientId(1);
		patientBean.setSex("F");
		patientBean.setBirthdate(LocalDate.of(2000, 01, 01));

		when(patientProxy.getPatientById(1)).thenReturn(patientBean);

		PatientAssessmentService patientAssessementServiceMocked = Mockito.spy(patientAssessmentService);

		Mockito.doReturn(5).when(patientAssessementServiceMocked).countingTriggerWords(Mockito.any());

		PatientAssessment assessment = patientAssessementServiceMocked.calculatePatientAssessment(1);

		assertThat(assessment.getAssessmentResult()).isEqualTo("In Danger");
	}

	@Test
	@DisplayName("Test assessement for age <30, sexe = F and count of trigger words = 7, should be equal to Early onset")
	public void evaluate_AgeLess30SexeFAnd7TriggerWords_ExpectEarlyOnset() {

		PatientBean patientBean = new PatientBean();
		patientBean.setPatientId(1);
		patientBean.setSex("F");
		patientBean.setBirthdate(LocalDate.of(2000, 01, 01));

		when(patientProxy.getPatientById(1)).thenReturn(patientBean);

		PatientAssessmentService patientAssessementServiceMocked = Mockito.spy(patientAssessmentService);

		Mockito.doReturn(7).when(patientAssessementServiceMocked).countingTriggerWords(Mockito.any());

		PatientAssessment assessment = patientAssessementServiceMocked.calculatePatientAssessment(1);

		assertThat(assessment.getAssessmentResult()).isEqualTo("Early onset");
	}

	@Test
	@DisplayName("Test assessement for age <30, sexe = M and count of trigger words = 1, should be equal to None")
	public void evaluate_AgeLess30SexeMAnd1TriggerWords_ExpectNone() {

		PatientBean patientBean = new PatientBean();
		patientBean.setPatientId(1);
		patientBean.setSex("M");
		patientBean.setBirthdate(LocalDate.of(2000, 01, 01));

		when(patientProxy.getPatientById(1)).thenReturn(patientBean);

		PatientAssessmentService patientAssessementServiceMocked = Mockito.spy(patientAssessmentService);

		Mockito.doReturn(1).when(patientAssessementServiceMocked).countingTriggerWords(Mockito.any());

		PatientAssessment assessment = patientAssessementServiceMocked.calculatePatientAssessment(1);

		assertThat(assessment.getAssessmentResult()).isEqualTo("None");
	}

	@Test
	@DisplayName("Test assessement for age <30, sexe = M and count of trigger words = 3, should be equal to In Danger")
	public void evaluate_AgeLess30SexeMAnd5TriggerWords_ExpectInDanger() {

		PatientBean patientBean = new PatientBean();
		patientBean.setPatientId(1);
		patientBean.setSex("M");
		patientBean.setBirthdate(LocalDate.of(2000, 01, 01));

		when(patientProxy.getPatientById(1)).thenReturn(patientBean);

		PatientAssessmentService patientAssessementServiceMocked = Mockito.spy(patientAssessmentService);

		Mockito.doReturn(3).when(patientAssessementServiceMocked).countingTriggerWords(Mockito.any());

		PatientAssessment assessment = patientAssessementServiceMocked.calculatePatientAssessment(1);

		assertThat(assessment.getAssessmentResult()).isEqualTo("In Danger");
	}

	@Test
	@DisplayName("Test assessement for age <30, sexe = M and count of trigger words = 7, should be equal to Early onset")
	public void evaluate_AgeLess30SexeMAnd7TriggerWords_ExpectEarlyOnset() {

		PatientBean patientBean = new PatientBean();
		patientBean.setPatientId(1);
		patientBean.setSex("M");
		patientBean.setBirthdate(LocalDate.of(2000, 01, 01));

		when(patientProxy.getPatientById(1)).thenReturn(patientBean);

		PatientAssessmentService patientAssessementServiceMocked = Mockito.spy(patientAssessmentService);

		Mockito.doReturn(7).when(patientAssessementServiceMocked).countingTriggerWords(Mockito.any());

		PatientAssessment assessment = patientAssessementServiceMocked.calculatePatientAssessment(1);

		assertThat(assessment.getAssessmentResult()).isEqualTo("Early onset");
	}
}
