package com.openclassrooms.mediscreenPatientAssessment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.openclassrooms.mediscreenPatientAssessment.model.TriggerWord;
import com.openclassrooms.mediscreenPatientAssessment.service.TriggerWordService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * The REST controller for CRUD operations on trigger words. No POST mapping for
 * updating because the word is the ID.
 * 
 * @author emmanuel
 *
 */
@Api("API pour gérer la liste des termes déclencheurs pour l'évaluation du risque.")
@RestController
public class TriggerWordController {

	@Autowired
	private TriggerWordService triggerWordService;

	/**
	 * Obtains the list of all trigger words.
	 * 
	 * @return A list of TriggerWord objects
	 */
	@ApiOperation("Récupère la liste des termes déclencheurs.")
	@GetMapping("/settings/triggerWords")
	public List<TriggerWord> getTriggerWords() {
		return triggerWordService.getTriggerWords();
	}

	/**
	 * Adds a new trigger word.
	 * 
	 * @param triggerWord - The trigger word to add
	 */
	@ApiOperation("Ajoute un terme déclencheur.")
	@PostMapping("/settings/triggerWord/add")
	public void addTriggerWord(@RequestParam("triggerWord") String triggerWord) {
		triggerWordService.addTriggerWord(triggerWord);
	}

	/**
	 * Deletes a trigger word.
	 * 
	 * @param triggerWord - The trigger word to delete
	 */
	@ApiOperation("Supprime un terme déclencheur.")
	@DeleteMapping("/settings/triggerWord/delete")
	public void deleteTriggerWord(@RequestParam("triggerWord") String triggerWord) {
		triggerWordService.deleteTriggerWord(triggerWord);
	}

}
