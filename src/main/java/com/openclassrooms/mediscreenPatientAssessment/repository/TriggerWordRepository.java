package com.openclassrooms.mediscreenPatientAssessment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.openclassrooms.mediscreenPatientAssessment.model.TriggerWord;

@Repository
public interface TriggerWordRepository extends JpaRepository<TriggerWord, String> {

}
