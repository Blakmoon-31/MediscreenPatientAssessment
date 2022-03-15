package com.openclassrooms.mediscreenPatientAssessment.proxy;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.openclassrooms.mediscreenPatientAssessment.bean.PatientBean;

/**
 * Proxy used to connect to the Patient service. URL - The url use the name of
 * the Docker container (patient) to communicate between containers. Use
 * localhost if application is not run from a container. Ports are the same.
 * 
 * @author emmanuel
 *
 */
@FeignClient(name = "Mediscreen-Patient", url = "${patient.proxy.host}")
public interface PatientProxy {

	/**
	 * Gets the list of all patients.
	 * 
	 * @return A list of PatientBean objects
	 */
	@GetMapping("/patient/list")
	List<PatientBean> getPatients();

	/**
	 * Gets a patient by his ID.
	 * 
	 * @param patientId - The ID of the patient to get
	 * @return A PatientBean object
	 */
	@GetMapping("/patient/get/id")
	PatientBean getPatientById(@RequestParam("patientId") int patientId);

	/**
	 * Gets a patient by his family and given name.
	 * 
	 * @param familyName - The family name of the patient
	 * @param givenName  - The given name of the patient
	 * @return A PatientBean object
	 */
	@GetMapping("/patient/get/name")
	PatientBean getPatientByName(@RequestParam("familyName") String familyName,
			@RequestParam("givenName") String givenName);

}
