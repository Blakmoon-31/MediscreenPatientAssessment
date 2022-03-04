package com.openclassrooms.mediscreenPatientAssessment.proxy;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.openclassrooms.mediscreenPatientAssessment.bean.PatientBean;

@FeignClient(name = "Mediscreen-Patient", url = "localhost:8081")
public interface PatientProxy {

	@GetMapping("/patient/list")
	List<PatientBean> getPatients();

	@GetMapping("/patient/get/id")
	PatientBean getPatientById(@RequestParam("patientId") int patientId);

	@GetMapping("/patient/get/name")
	PatientBean getPatientByName(@RequestParam("familyName") String familyName,
			@RequestParam("givenName") String givenName);

}
