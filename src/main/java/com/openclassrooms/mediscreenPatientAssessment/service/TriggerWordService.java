package com.openclassrooms.mediscreenPatientAssessment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openclassrooms.mediscreenPatientAssessment.model.TriggerWord;
import com.openclassrooms.mediscreenPatientAssessment.repository.TriggerWordRepository;

@Service
public class TriggerWordService {

	@Autowired
	private TriggerWordRepository triggerWordRepository;

	public List<TriggerWord> getTriggerWords() {
		return triggerWordRepository.findAll();
	}

	public void addTriggerWord(TriggerWord triggerWord) {
		triggerWordRepository.save(triggerWord);

	}

	public void deleteTriggerWord(String triggerWord) {
		triggerWordRepository.deleteById(triggerWord);

	}

}
