package com.openclassrooms.mediscreenPatientAssessment.bean;

import java.time.LocalDate;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The model of the PatientBean object used to obtain the Patient object from
 * the service Patient.
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
