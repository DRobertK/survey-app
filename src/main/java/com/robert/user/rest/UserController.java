package com.robert.user.rest;

import com.robert.user.UserService;
import com.robert.user.domain.User;
import com.robert.user.rest.dto.UserResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@RestController
// TODO: append /api to path
@RequestMapping(value = "api/users")
public class UserController {

    // TODO: 0. add logger and log messages in controller
    private static final Logger logger = LoggerFactory.getLogger(UserController.class.getName());

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    //ResponseParam and ResponseEntity
    @GetMapping("/userAge")
    ResponseEntity<String> ageUser(
            @RequestParam("yearOfBirth") LocalDate yearOfBirth) {

        LocalDate currentDate = LocalDate.now();
        int age = Period.between(yearOfBirth, currentDate).getYears();

        if (Period.between(yearOfBirth, currentDate).getYears() > 0) {
            return new ResponseEntity<>("You're age is: " + age, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Wrong value", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/hello")
    ResponseEntity<String> hello() {
        return new ResponseEntity<>("Hello World", HttpStatus.OK);
    }

    // find all
    @GetMapping
    public List<User> findAll() {
        return userService.findAll();
    }

    // TODO: 1. fix user CRUD
    // find one
    @GetMapping("/{id}")
    public User findById(@PathVariable final Long id) {
        logger.debug("find by id {}", id);
        return userService.findById(id);
    }

    // create
    @PostMapping
    public void create(@RequestBody User user) {
        userService.save(user);
    }

    // update
    @PutMapping
    public User update(@RequestBody User user) {
        return userService.save(user);
    }

    // TODO: replace with PATCH
    @PatchMapping("/{id}")
    public User partialUpdateUserMonkey(@RequestBody UserResponse userResponse, @PathVariable Long id) {

        User userToUpdate = userService.findById(id);
        map(userToUpdate, userResponse);
        return userService.save(userToUpdate);
    }

    // delete

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        userService.deleteById(id);
    }

    private void map(User user, UserResponse dto) {
        user.setCity(dto.getCity());
        user.setCountry(dto.getCountry());
        user.setEmailAddress(dto.getEmailAddress());
    }
}
