package com.robert.survey;

import com.robert.survey.domain.Survey;
import com.robert.survey.domain.SurveyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SurveyService {

    private SurveyRepository surveyRepository;

    @Autowired
    public SurveyService(SurveyRepository surveyRepository) {
        this.surveyRepository = surveyRepository;
    }

    public Survey findById(Long id) {
        return surveyRepository.findById(id).orElseThrow(() -> new IllegalArgumentException());
    }

    public List<Survey> findAll() {
        return surveyRepository.findAll();
    }


    public Survey save(Survey survey) {
        return surveyRepository.save(survey);
    }

    public Survey update(Survey survey) {
        return surveyRepository.save(survey);
    }

    public void deleteById(Long id) {
        surveyRepository.deleteById(id);
    }


}
