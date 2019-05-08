package com.robert.survey.domain;

import com.robert.question.domain.Question;
import com.robert.user.domain.User;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity(name = "survey")
public class Survey {

    // TODO: 4. add properties
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nameOfSurvey;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user = new User();

    // TODO: 5. add one to many relationship
    @OneToMany(
            mappedBy = "survey",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Question> questions = new ArrayList<>();

    public Survey() {
    }

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getNameOfSurvey() {
        return nameOfSurvey;
    }

    public void setNameOfSurvey(String nameOfSurvey) {
        this.nameOfSurvey = nameOfSurvey;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Survey)) return false;
        Survey survey = (Survey) o;
        return id == survey.id &&
                nameOfSurvey.equals(survey.nameOfSurvey);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nameOfSurvey);
    }
}
