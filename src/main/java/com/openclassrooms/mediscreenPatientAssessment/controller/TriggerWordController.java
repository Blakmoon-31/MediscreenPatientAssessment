package com.openclassrooms.mediscreenPatientAssessment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.openclassrooms.mediscreenPatientAssessment.model.TriggerWord;
import com.openclassrooms.mediscreenPatientAssessment.service.TriggerWordService;

@RestController
public class TriggerWordController {

	@Autowired
	private TriggerWordService triggerWordService;

	@GetMapping("/settings")
	public List<TriggerWord> getTriggerWords() {
		return triggerWordService.getTriggerWords();
	}

	@PostMapping("/setting/add")
	public void addTriggerWord(@RequestBody TriggerWord triggerWord) {
		triggerWordService.addTriggerWord(triggerWord);
	}

	@DeleteMapping("/setting/delete")
	public void deleteTriggerWord(@RequestParam("triggerWord") String triggerWord) {
		triggerWordService.deleteTriggerWord(triggerWord);
	}

}
