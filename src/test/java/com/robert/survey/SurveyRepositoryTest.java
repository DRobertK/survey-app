package com.robert.survey;

import com.robert.question.domain.Question;
import com.robert.question.domain.QuestionRepository;
import com.robert.survey.domain.Survey;
import com.robert.survey.domain.SurveyRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class SurveyRepositoryTest {

    @Autowired
    private SurveyRepository surveyRepository;

    @Autowired
    private QuestionRepository questionRepository;


    @Test
    public void givenSurvey_whenCreateSurvey_thenOk() {
        Survey survey = new Survey();
        survey.setName("Happy test");

        surveyRepository.save(survey);
        assertThat(surveyRepository.count()).isEqualTo(1);
    }

    // survey with 1 question
    @Test
    public void givenSurveyWithQuestion_thenOk() {
        Survey survey = new Survey();
        survey.setName("test survey");

        Question question = new Question();
        question.setText("test question");

        survey.addQuestion(question);
        surveyRepository.save(survey);

        assertThat(survey).isNotNull();
    }
}