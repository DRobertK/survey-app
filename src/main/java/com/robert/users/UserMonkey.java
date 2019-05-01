package com.robert.users;

import com.robert.survey.Survey;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity(name = "user_monkey")
public class UserMonkey {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String city;
    private String country;

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Survey> surveys = new ArrayList<>();

    public UserMonkey() {
    }

    public UserMonkey(String firstName, String lastName, String emailAddress, String city, String country) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.city = city;
        this.country = country;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserMonkey that = (UserMonkey) o;
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
