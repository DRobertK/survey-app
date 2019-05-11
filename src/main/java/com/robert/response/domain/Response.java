package com.robert.response.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

// FIXME: add response entity
@Entity(name = "Response")
@Table
public class Response {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NotNull
    private String questionResponse;

    public Response(String questionResponse) {
        this.questionResponse = questionResponse;
    }

    public String getQuestionResponse() {
        return questionResponse;
    }

    public void setQuestionResponse(String questionResponse) {
        this.questionResponse = questionResponse;
    }

    // FIXME: association with user


    // FIXME: association with question
}
