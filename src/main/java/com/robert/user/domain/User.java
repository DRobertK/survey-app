package com.robert.user.domain;

import com.robert.survey.domain.Survey;

import javax.persistence.*;
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

    // FIXME: add validation

    // TODO: add fields
    /*
        private String username;
        private String email;
        private String password;
        private String firstName;
        private String lastName;
     */
    @Column // optional
    private String firstName;
    private String lastName;
    private String email;
    private String username;
    private String password;

    // TODO: use temporal field
    private LocalDate createdOn;

    // TODO: use embedded type
    @Embedded
    private Address address;

    // TODO: use enum field
    private Role role;

    // FetchType.EAGER: default for @ManyToOne and @OneToOne
    // FetchType.LAZY: default for @OneToMany and @ManyToMany

    // FIXME: one to many relationship
    // don't use uni-directional one-to-many
    // use bidirectional one-to-many
    // use uni-directional many-to-one
    @OneToMany(
            mappedBy = "user",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Survey> surveys = new ArrayList<>();

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

    // TODO: add utility methods
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
