package com.robert.survey;

import com.robert.question.Question;
import com.robert.users.UserMonkey;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "survey")
public class Survey {
    //
//    // TODO: 4. add properties
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nameOfSurvey;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id")
    Question question;
    @OneToMany(
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            mappedBy = "survey"
    )
//            @JoinColumn(name = "user_monkey_id",insertable = false, updatable = false)
    private List<UserMonkey> userMonkeys = new ArrayList<>();

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
