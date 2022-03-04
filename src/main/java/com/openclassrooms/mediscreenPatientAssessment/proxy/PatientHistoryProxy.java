package com.openclassrooms.mediscreenPatientAssessment.proxy;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.openclassrooms.mediscreenPatientAssessment.bean.PatientHistoryBean;

@FeignClient(name = "Mediscreen-PatientHistory", url = "localhost:8082")
public interface PatientHistoryProxy {

	@GetMapping("/patient/histories/get")
	List<PatientHistoryBean> getPatientHistoriesByPatientId(@RequestParam("patientId") int patientId);

}
