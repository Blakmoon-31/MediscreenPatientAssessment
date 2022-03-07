package com.openclassrooms.mediscreenPatientAssessment.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The model of the TriggerWord entity in the database.
 * 
 * @author emmanuel
 *
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "trigger_word")
public class TriggerWord {

	@Id
	@Column(name = "trigger_word")
	@Size(max = 20)
	@NotBlank
	private String triggerWord;

}
