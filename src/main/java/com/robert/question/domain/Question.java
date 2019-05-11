package com.robert.question.domain;

import com.robert.survey.domain.Survey;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "question")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String textQuestion;
    private String textAnswer;

    public Question() {
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "survey_id")
    private Survey survey = new Survey();

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

    public Survey getSurvey() {
        return survey;
    }

    public void setSurvey(Survey survey) {
        this.survey = survey;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Question)) return false;
        Question question = (Question) o;
        return id == question.id &&
                textQuestion.equals(question.textQuestion) &&
                textAnswer.equals(question.textAnswer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, textQuestion, textAnswer);
    }
}
