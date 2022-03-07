package com.openclassrooms.mediscreenPatientAssessment.bean;

import java.time.LocalDate;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The model of the PatientHistoryBean object used to obtain the PatientHistory
 * document from the service PatientHistory.
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
