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

    // TODO: 5. add one to many relationship
    @OneToMany(
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            mappedBy = "survey"
    )
//            @JoinColumn(name = "user_monkey_id",insertable = false, updatable = false)
    private List<UserMonkey> userMonkeys = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id")
    private Question question;


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


    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public List<UserMonkey> getUserMonkeys() {
        return userMonkeys;
    }

    public void setUserMonkeys(List<UserMonkey> userMonkeys) {
        this.userMonkeys = userMonkeys;
    }
}
