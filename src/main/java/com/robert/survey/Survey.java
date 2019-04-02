package com.robert.survey;

import com.robert.question.Question;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Entity(name = "_survey")
public class Survey {
    //
//    // TODO: 4. add properties
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nameOfSurvey;


    public Survey(long id, String nameOfSurvey) {
        this.id = id;
        this.nameOfSurvey = nameOfSurvey;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNameOfSurvey() {
        return nameOfSurvey;
    }

    public void setNameOfSurvey(String nameOfSurvey) {
        this.nameOfSurvey = nameOfSurvey;
    }

    // TODO: 5. add one to many relationship
    public List<Question> getQuestions() {
        return null;
    }
}
