package com.robert.survey.domain;

import com.robert.question.domain.Question;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity(name = "Survey")
@Table(name = "survey")
public class Survey {

    // 4. add properties
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Size(min = 1, max = 60)
    private String name;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "user_id")
//    private Profile profile = new Profile();

    // 5. add one to many relationship
    @OneToMany(
            mappedBy = "survey",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Question> questions = new ArrayList<>();

    public Survey() {
    }

    public Survey(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

//    public Profile getProfile() {
//        return profile;
//    }
//
//    public void setProfile(Profile profile) {
//        this.profile = profile;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    /// add utility methods
    // used to synchronize both side of the bidirectional association
    // addQuestion
    public void addQuestion(Question question) {
        questions.add(question);
        question.setSurvey(this);
    }

    //remove question
    public void removeQuestion(Question question) {
        questions.remove(question);
        question.setSurvey(null);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Survey)) return false;
        Survey survey = (Survey) o;
        return id == survey.id &&
                name.equals(survey.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
