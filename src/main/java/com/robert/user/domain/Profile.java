package com.robert.user.domain;

import com.robert.response.domain.Response;
import com.robert.survey.domain.Survey;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity // the java object (default name = User)
@Table(name = "user_profile") // optional
public class Profile {

    // needed in order to auto increment in sql insert
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column // optional
    @NotNull(message = " First name is a required field")
    @Size(min = 1, max = 60, message = "First name cannot be longer than 60 characters")
    private String firstName;

    @NotNull(message = " Last name is a required field")
    @Size(min = 1, max = 60, message = "Last name cannot be longer than 60 characters")
    private String lastName;

    @NotNull(message = " email address is a required field")
    @Size(min = 1, max = 60, message = "email address cannot be longer than 60 characters")
    private String email;

    // use embedded type
    @Embedded
    private Address address;

    // FetchType.EAGER: default for @ManyToOne and @OneToOne
    // FetchType.LAZY: default for @OneToMany and @ManyToMany

    // one to many relationship
    // don't use uni-directional one-to-many
    // use bidirectional one-to-many
    // use uni-directional many-to-one
    @OneToMany(
            mappedBy = "profile",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Survey> surveys = new ArrayList<>();

    @OneToMany(
            mappedBy = "profile",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Response> responses = new ArrayList<>();

    // needed by hibernate
    public Profile() {
    }

    public Profile(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Survey> getSurveys() {
        return surveys;
    }

    public void setSurveys(List<Survey> surveys) {
        this.surveys = surveys;
    }

    // add utility methods
    // used to synchronize both side of the bidirectional association
    // addSurvey
    public void addSurvey(Survey survey) {
        surveys.add(survey);
        survey.setProfile(this);
    }

    // removeSurvey
    public void removeSurvey(Survey survey) {
        surveys.remove(survey);
        survey.setProfile(null);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Profile that = (Profile) o;
        return id == that.id &&
                firstName.equals(that.firstName) &&
                lastName.equals(that.lastName) &&
                email.equals(that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, email, address, surveys, responses);
    }
}
