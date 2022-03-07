package com.openclassrooms.mediscreenPatientAssessment.integration;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.openclassrooms.mediscreenPatientAssessment.controller.TriggerWordController;
import com.openclassrooms.mediscreenPatientAssessment.model.TriggerWord;

@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
public class TriggerWordControllerIT {

	@Autowired
	private TriggerWordController triggerWordController;

	@BeforeAll
	public void setTestData() {
		triggerWordController.addTriggerWord("Test delete");
	}

	@AfterAll
	public void resetTestData() {
		triggerWordController.deleteTriggerWord("Test add");
	}

	@Test
	public void testGetTriggerWords() {

		List<TriggerWord> triggerWords = triggerWordController.getTriggerWords();

		assertThat(triggerWords.size()).isGreaterThan(0);
	}

	@Test
	public void testAddTriggerWord() {

		List<TriggerWord> triggerWordsBefore = triggerWordController.getTriggerWords();

		triggerWordController.addTriggerWord("Test add");

		List<TriggerWord> triggerWordsAfter = triggerWordController.getTriggerWords();

		assertThat(triggerWordsAfter.size()).isEqualTo(triggerWordsBefore.size() + 1);
	}

	@Test
	public void testDeleteTriggerWord() {
		List<TriggerWord> triggerWordsBefore = triggerWordController.getTriggerWords();

		triggerWordController.deleteTriggerWord("Test delete");
		;

		List<TriggerWord> triggerWordsAfter = triggerWordController.getTriggerWords();

		assertThat(triggerWordsAfter.size()).isEqualTo(triggerWordsBefore.size() - 1);
	}
}
