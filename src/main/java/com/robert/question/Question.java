package com.robert.question;

import com.robert.survey.Survey;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "question")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String textQuestion;
    private String textAnswer;

    @OneToMany(
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            mappedBy = "question"
    )
//    @JoinColumn(name = "survey", insertable = false, updatable = false)
    private List<Survey> surveys = new ArrayList<>();

    public Question(long id, String textQuestion, String textAnswer) {
        this.id = id;
        this.textQuestion = textQuestion;
        this.textAnswer = textAnswer;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTextQuestion() {
        return textQuestion;
    }

    public void setTextQuestion(String textQuestion) {
        this.textQuestion = textQuestion;
    }

    public String getTextAnswer() {
        return textAnswer;
    }

    public void setTextAnswer(String textAnswer) {
        this.textAnswer = textAnswer;
    }

    public List<Survey> getSurveys() {
        return surveys;
    }

    public void setSurveys(List<Survey> surveys) {
        this.surveys = surveys;
    }
}
