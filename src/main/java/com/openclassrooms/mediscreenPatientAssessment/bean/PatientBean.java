package com.openclassrooms.mediscreenPatientAssessment.bean;

import java.time.LocalDate;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The model of the Patient entity in the database. Will be mapped into
 * PatientDto objects for exchange with the web UI.
 * 
 * @author emmanuel
 *
 */
@Getter
@Setter
@NoArgsConstructor
public class PatientBean {

	private int patientId;

	private String familyName;

	private String givenName;

	private String sex;

	private LocalDate birthdate;

}
