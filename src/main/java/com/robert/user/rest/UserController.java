package com.robert.user.rest;

import com.robert.user.UserService;
import com.robert.user.domain.User;
import com.robert.user.rest.dto.UserResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// FIXME: replace entity with dto
@RestController
@RequestMapping(UserController.API_USERS)
public class UserController {

    public static final String API_USERS = "/api/users";

    // FIXME: 0. add logger and log messages in controller
    private static final Logger logger = LoggerFactory.getLogger(UserController.class.getName());

    private UserService userService;

    // TODO: inject user service in constructor
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // TODO: implement find by id using GET
    @GetMapping
    public List<User> findAll() {
        return userService.findAll();
    }

    // TODO: implement find by id using GET
    @GetMapping("/{id}")
    public User findById(@PathVariable final Long id) {
        logger.debug("find by id {}", id);
        return userService.findById(id);
    }

    // TODO: implement create using POST
    @PostMapping
    public void create(@RequestBody User user) {
        userService.save(user);
    }

    // TODO: implement update using PUT
    @PutMapping
    public User update(@RequestBody User user) {
        return userService.save(user);
    }

    // TODO: implement partial update using PATCH
    @PatchMapping("/{id}")
    public User partialUpdateUserMonkey(@RequestBody UserResponse userResponse, @PathVariable Long id) {

        User userToUpdate = userService.findById(id);
        map(userToUpdate, userResponse);
        return userService.save(userToUpdate);
    }

    // TODO: implement delete using DELETE
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        userService.deleteById(id);
    }

    // FIXME: use @RequestParam for a query param
    // http://localhost:8080/api/users?lastName=smith

    private void map(User user, UserResponse dto) {
        user.setCity(dto.getCity());
        user.setCountry(dto.getCountry());
        user.setEmailAddress(dto.getEmailAddress());
    }
}
