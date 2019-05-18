package com.robert.survey;

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

    @Test
    public void givenSurvey_whenCreateSurvey_thenOk() {
//        surveyRepository.save(UserFactory.createFullUser());
        assertThat(surveyRepository.count()).isEqualTo(1);
    }


}