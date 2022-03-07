package com.openclassrooms.mediscreenPatientAssessment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.openclassrooms.mediscreenPatientAssessment.bean.PatientBean;
import com.openclassrooms.mediscreenPatientAssessment.model.PatientAssessment;
import com.openclassrooms.mediscreenPatientAssessment.proxy.PatientProxy;
import com.openclassrooms.mediscreenPatientAssessment.service.PatientAssessmentService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * The REST controller for the evaluation of diabetes assessments for patients.
 * 
 * @author emmanuel
 *
 */
@Api("API pour l'évaluation du risque chez les patients.")
@RestController
public class PatientAssessmentController {

	@Autowired
	private PatientAssessmentService patientAssessmentService;

	@Autowired
	private PatientProxy patientProxy;

	/**
	 * Gets the result of the diabetes assessment for a patient by his ID.
	 * 
	 * @param patientId - The ID of the patient to evaluate
	 * @return A PatientAssessment object
	 */
	@ApiOperation("Calcule le risque de diabète pour un patient à partir de son ID.")
	@GetMapping("/assess/id")
	public PatientAssessment calculatePatientAssessmentByPatientId(@RequestParam("patientId") int patientId) {

		PatientAssessment assessment = patientAssessmentService.calculatePatientAssessment(patientId);

		return assessment;
	}

	/**
	 * Gets the result of the diabetes assessment for a patient by his family and
	 * given name. The ID is first retrieved then used to gets the assessment.
	 * 
	 * @param familyName - The family name of the patient to evaluate
	 * @param givenName  - The given name of the patient to evaluate
	 * @return A PatientAssessment object
	 */
	@ApiOperation("Calcule le risque de diabète pour un patient à partir de son nom de famille et de son prénom.")
	@GetMapping("/assess/name")
	public PatientAssessment calculatePatientAssessmentByPatientName(@RequestParam("familyName") String familyName,
			@RequestParam("givenName") String givenName) {

		PatientBean patientBean = patientProxy.getPatientByName(familyName, givenName);
		PatientAssessment assessment = patientAssessmentService.calculatePatientAssessment(patientBean.getPatientId());

		return assessment;
	}
}
