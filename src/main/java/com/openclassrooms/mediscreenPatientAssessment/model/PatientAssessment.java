package com.openclassrooms.mediscreenPatientAssessment.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The model of the PatientAssessment object.
 * 
 * @author emmanuel
 *
 */
@Getter
@Setter
@NoArgsConstructor
public class PatientAssessment {

	private int patientId;

	private int age;

	private String assessmentResult;
}
