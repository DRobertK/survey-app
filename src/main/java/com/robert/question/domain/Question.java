package com.robert.question.domain;

import com.robert.response.domain.Response;
import com.robert.survey.domain.Survey;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity(name = "question")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String textQuestion;

    public Question() {
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "survey_id")
    private Survey survey = new Survey();

    @OneToMany(
            mappedBy = "question",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Response> responses = new ArrayList<>();

    public Question(long id, String textQuestion) {
        this.id = id;
        this.textQuestion = textQuestion;
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

    public Survey getSurvey() {
        return survey;
    }

    public void setSurvey(Survey survey) {
        this.survey = survey;
    }

    public void addResponse(Response response) {
        responses.add(response);
        response.setQuestion(this);
    }

    public void removeResponse(Response response) {
        responses.remove(response);
        response.setQuestion(null);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Question)) return false;
        Question question = (Question) o;
        return id == question.id &&
                textQuestion.equals(question.textQuestion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, textQuestion);
    }


}
