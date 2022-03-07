package com.openclassrooms.mediscreenPatientAssessment.proxy;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.openclassrooms.mediscreenPatientAssessment.bean.PatientHistoryBean;

/**
 * Proxy used to connect to the PatientHistory service.
 * 
 * @author emmanuel
 *
 */
@FeignClient(name = "Mediscreen-PatientHistory", url = "localhost:8082")
public interface PatientHistoryProxy {

	/**
	 * Gets the histories of a patient by his ID.
	 * 
	 * @param patientId - The ID of the patient
	 * @return A list of PatientHistoryBean objects
	 */
	@GetMapping("/patient/histories/get")
	List<PatientHistoryBean> getPatientHistoriesByPatientId(@RequestParam("patientId") int patientId);

}
