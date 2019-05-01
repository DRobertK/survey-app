package com.robert.user.domain;

import com.robert.survey.Survey;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
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

    // FIXME: add fields
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
    private String emailAddress;
    private String city;
    private String country;

    // FIXME: use temporal field
//    private LocalDate createdOn;

    // FIXME: use embedded type
//    private Address address;

    // FIXME: use enum fields
    private Role role;

    // FetchType.EAGER: default for @ManyToOne and @OneToOne
    // FetchType.LAZY: default for @OneToMany and @ManyToMany

    // FIXME: one to many relationship
    // don't use uni-directional one-to-many
    // use bidirectional one-to-many
    // use uni-directional many-to-one
    @OneToMany(
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    private List<Survey> surveys = new ArrayList<>();

    // needed by hibernate
    public User() {
    }

    public User(String firstName, String lastName, String emailAddress, String city, String country) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.city = city;
        this.country = country;
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

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<Survey> getSurveys() {
        return surveys;
    }

    public void setSurveys(List<Survey> surveys) {
        this.surveys = surveys;
    }

    // TODO: add utility methods
    // used to synchronize both side of the bidirectional association
    // addSurvey
    // removeSurvey

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User that = (User) o;
        return id == that.id &&
                firstName.equals(that.firstName) &&
                lastName.equals(that.lastName) &&
                emailAddress.equals(that.emailAddress) &&
                city.equals(that.city) &&
                country.equals(that.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, emailAddress, city, country);
    }

    @Override
    public String
    toString() {
        return "User{" +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                '}';


    }
}
