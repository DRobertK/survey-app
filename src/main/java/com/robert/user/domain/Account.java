package com.robert.user.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity(name = "user_account")
@Table(name = "user_account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "user name is a required field")
    @Size(min = 1, max = 60, message = "user name cannot be longer than 60 characters")
    private String userName;

    @NotNull(message = "password name is a required field")
    @Size(min = 1, max = 60, message = "password cannot be longer than 60 characters")
    private String password;

    // use temporal field
    private LocalDate createdOn;


    // use enum field
    private Role role;

    public Account() {
    }

    public Account(String password, LocalDate createdOn, Role role) {
        this.password = password;
        this.createdOn = createdOn;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDate createdOn) {
        this.createdOn = createdOn;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
