package com.openclassrooms.mediscreenPatientAssessment.service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openclassrooms.mediscreenPatientAssessment.bean.PatientBean;
import com.openclassrooms.mediscreenPatientAssessment.bean.PatientHistoryBean;
import com.openclassrooms.mediscreenPatientAssessment.model.PatientAssessment;
import com.openclassrooms.mediscreenPatientAssessment.model.TriggerWord;
import com.openclassrooms.mediscreenPatientAssessment.proxy.PatientHistoryProxy;
import com.openclassrooms.mediscreenPatientAssessment.proxy.PatientProxy;
import com.openclassrooms.mediscreenPatientAssessment.repository.TriggerWordRepository;

/**
 * Service for the evaluation of diabetes assessments for patients.
 * 
 * @author emmanuel
 *
 */
@Service
public class PatientAssessmentService {

	@Autowired
	private PatientProxy patientProxy;

	@Autowired
	private PatientHistoryProxy patientHistoryProxy;

	@Autowired
	private TriggerWordRepository triggerWordRepository;

	/**
	 * Gets the assessment for a patient by his ID.
	 * 
	 * @param patientId - The ID of the patient to evaluate
	 * @return A PatientAssessment object
	 */
	public PatientAssessment calculatePatientAssessment(int patientId) {

		PatientAssessment patientAssessment = new PatientAssessment();
		PatientBean patientBean = patientProxy.getPatientById(patientId);

		patientAssessment.setPatientId(patientId);
		patientAssessment.setAge(calculateAge(patientBean.getBirthdate()));

		List<PatientHistoryBean> patientHistories = patientHistoryProxy.getPatientHistoriesByPatientId(patientId);

		int countTriggerWords = countingTriggerWords(patientHistories);

		patientAssessment
				.setAssessmentResult(evaluate(countTriggerWords, patientBean.getSex(), patientAssessment.getAge()));

		return patientAssessment;
	}

	/**
	 * Evaluates the risk's level by the number of trigger words and the patient's
	 * age and sexe.
	 * 
	 * @param countTriggerWords - The number of trigger words found in patient's
	 *                          histories
	 * @param sex               - The patient's sex
	 * @param age               - The patient's age
	 * @return A string representing the risk's level
	 */
	private String evaluate(int countTriggerWords, String sex, int age) {

		if (age >= 30) {
			if (countTriggerWords <= 1) {
				return "None";
			} else if (countTriggerWords >= 2 && countTriggerWords <= 5) {
				return "Borderline";
			} else if (countTriggerWords >= 6 && countTriggerWords <= 7) {
				return "In Danger";
			} else if (countTriggerWords >= 8) {
				return "Early onset";
			}
		}

		if (age < 30 && sex.equals("M")) {
			if (countTriggerWords <= 2) {
				return "None";
			} else if (countTriggerWords >= 3 && countTriggerWords <= 4) {
				return "In Danger";
			} else if (countTriggerWords >= 5) {
				return "Early onset";
			}
		}

		if (age < 30 && sex.equals("F")) {
			if (countTriggerWords <= 3) {
				return "None";
			} else if (countTriggerWords >= 4 && countTriggerWords <= 6) {
				return "In Danger";
			} else if (countTriggerWords >= 7) {
				return "Early onset";
			}
		}

		return "Not evaluate";
	}

	/**
	 * Counts how many trigger words appears in a patient's history. One word is
	 * count only once even if it appears many times. The search is not case or
	 * accent sensitive.
	 * 
	 * @param patientHistories - Histories of the practitioner's note for a patient
	 * @return The number of trigger words found
	 */
	private int countingTriggerWords(List<PatientHistoryBean> patientHistories) {

		List<TriggerWord> triggerWords = triggerWordRepository.findAll();

		int count = 0;

		for (TriggerWord word : triggerWords) {
			for (PatientHistoryBean note : patientHistories) {
				if (StringUtils.stripAccents(note.getPractitionerNote().toLowerCase())
						.contains(StringUtils.stripAccents(word.getTriggerWord()).toLowerCase())) {
					count += 1;
					break;
				}
			}
		}

		return count;
	}

	/**
	 * Calculates the age of a patient.
	 * 
	 * @param birthdate - The birthdate of the patient
	 * @return A number representing the age in years
	 */
	public int calculateAge(LocalDate birthdate) {
		LocalDate today = LocalDate.now();
		int age = Period.between(birthdate, today).getYears();

		return age;

	}
}
