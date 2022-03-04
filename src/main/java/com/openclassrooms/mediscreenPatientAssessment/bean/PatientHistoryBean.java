package com.openclassrooms.mediscreenPatientAssessment.bean;

import java.time.LocalDate;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The model of the PatientHistory document in the database. Will be mapped into
 * PatientHistoryDto objects for exchange with the web UI.
 * 
 * @author emmanuel
 *
 */
@Getter
@Setter
@NoArgsConstructor
public class PatientHistoryBean {

	private String historyId;

	private int patientId;

	private LocalDate historyDate;

	private String practitionerNote;

}
