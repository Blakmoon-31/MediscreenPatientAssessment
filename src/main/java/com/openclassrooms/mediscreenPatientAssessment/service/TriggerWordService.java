package com.openclassrooms.mediscreenPatientAssessment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openclassrooms.mediscreenPatientAssessment.model.TriggerWord;
import com.openclassrooms.mediscreenPatientAssessment.repository.TriggerWordRepository;

/**
 * The service for CRUD operations on trigger wods.
 * 
 * @author emmanuel
 *
 */
@Service
public class TriggerWordService {

	@Autowired
	private TriggerWordRepository triggerWordRepository;

	/**
	 * Gets the list of all trigger words.
	 * 
	 * @return A list of TriggerWord objects
	 */
	public List<TriggerWord> getTriggerWords() {
		return triggerWordRepository.findAll();
	}

	/**
	 * Adds a trigger word into the database.
	 * 
	 * @param triggerWord - The trigger word to add
	 */
	public void addTriggerWord(String triggerWord) {
		TriggerWord triggerWordToAdd = new TriggerWord();
		triggerWordToAdd.setTriggerWord(triggerWord);
		triggerWordRepository.save(triggerWordToAdd);

	}

	/**
	 * Deletes a trigger word in the database.
	 * 
	 * @param triggerWord - The trigger to delete
	 */
	public void deleteTriggerWord(String triggerWord) {
		triggerWordRepository.deleteById(triggerWord);

	}

}
