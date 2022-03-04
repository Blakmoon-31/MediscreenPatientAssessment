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

@Api("API pour l'évaluation du risque chez les patients.")
@RestController
public class PatientAssessmentController {

	@Autowired
	private PatientAssessmentService patientAssessmentService;

	@Autowired
	private PatientProxy patientProxy;

	@GetMapping("/assess/id")
	public PatientAssessment calculatePatientAssessmentByPatientId(@RequestParam("patientId") int patientId) {

		PatientAssessment assessment = patientAssessmentService.calculatePatientAssessment(patientId);

		return assessment;
	}

	@GetMapping("/assess/name")
	public PatientAssessment calculatePatientAssessmentByPatientName(@RequestParam("familyName") String familyName,
			@RequestParam("givenName") String givenName) {

		PatientBean patientBean = patientProxy.getPatientByName(familyName, givenName);
		PatientAssessment assessment = patientAssessmentService.calculatePatientAssessment(patientBean.getPatientId());

		return assessment;
	}
}
