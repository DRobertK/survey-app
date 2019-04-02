package com.robert.survey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SurveyService {

    private SurveyRepository surveiRepository;

    @Autowired
    public SurveyService(SurveyRepository surveiRepository) {
        this.surveiRepository = surveiRepository;
    }

    public Survey findById(Long id) {
        return surveiRepository.findById(id).orElseThrow(() -> new IllegalArgumentException());
    }

    public List<Survey> findAll() {
        return surveiRepository.findAll();
    }


    public Survey save(Survey survey) {
        return (Survey) surveiRepository.save(survey);
    }

    public Survey update(Survey survey) {
        return (Survey) surveiRepository.save(survey);
    }

    public void deleteById(Long id) {
        surveiRepository.deleteById(id);
    }


}
