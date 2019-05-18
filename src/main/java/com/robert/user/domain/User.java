package com.robert.user.domain;

import com.robert.response.domain.Response;
import com.robert.survey.domain.Survey;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity // the java object (default name = User)
@Table(name = "user") // optional
public class User {

    // needed in order to auto increment in sql insert
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // add validation

    // add fields
    /*
        private String username;
        private String email;
        private String password;
        private String firstName;
        private String lastName;
     */
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

    @NotNull(message = "user name is a required field")
    @Size(min = 1, max = 60, message = "user name cannot be longer than 60 characters")
    private String username;

    @NotNull(message = "password name is a required field")
    @Size(min = 1, max = 60, message = "password cannot be longer than 60 characters")
    private String password;

    // use temporal field
    private LocalDate createdOn;

    // use embedded type
    @Embedded
    private Address address;

    // use enum field
    private Role role;

    // FetchType.EAGER: default for @ManyToOne and @OneToOne
    // FetchType.LAZY: default for @OneToMany and @ManyToMany

    // one to many relationship
    // don't use uni-directional one-to-many
    // use bidirectional one-to-many
    // use uni-directional many-to-one
    @OneToMany(
            mappedBy = "user",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Survey> surveys = new ArrayList<>();

    @OneToMany(
            mappedBy = "user",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Response> responses = new ArrayList<>();

    // needed by hibernate
    public User() {
    }

    public User(String firstName, String lastName, String email, String username,
                String password, LocalDate createdOn, Address address, Role role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.username = username;
        this.password = password;
        this.createdOn = createdOn;
        this.address = address;
        this.role = role;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Survey> getSurveys() {
        return surveys;
    }

    public void setSurveys(List<Survey> surveys) {
        this.surveys = surveys;
    }

    public LocalDate getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDate createdOn) {
        this.createdOn = createdOn;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    // add utility methods
    // used to synchronize both side of the bidirectional association
    // addSurvey
    public void addSurvey(Survey survey) {
        surveys.add(survey);
        survey.setUser(this);
    }

    // removeSurvey
    public void removeSurvey(Survey survey) {
        surveys.remove(survey);
        survey.setUser(null);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User that = (User) o;
        return id == that.id &&
                firstName.equals(that.firstName) &&
                lastName.equals(that.lastName) &&
                email.equals(that.email) &&
                username.equals(that.username) &&
                password.equals(that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, email, username, password);
    }

    @Override
    public String
    toString() {
        return "User{" +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", emailAddress='" + email + '\'' +
                ", user='" + username + '\'' +
                ", country='" + password + '\'' +
                '}';


    }
}
