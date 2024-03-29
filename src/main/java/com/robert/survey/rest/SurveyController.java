package com.robert.survey.rest;

import com.robert.survey.SurveyService;
import com.robert.survey.domain.Survey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/survey")
public class SurveyController {

    private SurveyService surveyService;

    @Autowired
    public SurveyController(SurveyService surveyService) {
        this.surveyService = surveyService;
    }

    // 2. add survey CRUD

    //create
    @PostMapping
    public Survey save(Survey survey) {
        return surveyService.save(survey);
    }

    //read
    @GetMapping
    public List<Survey> findAll() {
        return surveyService.findAll();
    }

    @GetMapping("/{id}")
    public Survey findById(@PathVariable Long id) {
        return surveyService.findById(id);
    }

    //update
    @PutMapping
    public Survey update(Survey survey) {
        return surveyService.save(survey);
    }

    //delete
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        surveyService.deleteById(id);
    }


}
