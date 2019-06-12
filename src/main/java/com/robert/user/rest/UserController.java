package com.robert.user.rest;

import com.robert.user.UserService;
import com.robert.user.domain.Profile;
import com.robert.user.rest.dto.UserMapper;
import com.robert.user.rest.dto.UserResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

// TODO: replace entity with dto
@RestController
@RequestMapping(UserController.API_USERS)
public class UserController {

    public static final String API_USERS = "/api/users";

    // 0. add logger and log messages in controller
    private static final Logger logger = LoggerFactory.getLogger(UserController.class.getName());

    private UserService userService;

    // inject user service in constructor
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // implement find by id using GET
    @GetMapping
//    @Scope("prototype")
    public List<Profile> findAll() {
        return userService.findAll();
    }

    // implement find by id using GET
    @GetMapping("/{id}")
    public Profile findById(@PathVariable final Long id) {
        logger.debug("find by id {}", id);
        return userService.findById(id);
    }

    // implement create using POST
    @PostMapping
    public void create(@RequestBody @Valid Profile profile) {
        userService.save(profile);
    }

    // implement update using PUT
    @PutMapping
    public Profile update(@RequestBody @Valid Profile profile) {
        return userService.save(profile);
    }

    // implement partial update using PATCH
    @PatchMapping("/{id}")
    public Profile partialUpdateUserMonkey(@RequestBody UserResponse userResponse, @PathVariable Long id) {

        Profile profileToUpdate = userService.findById(id);
        UserMapper.map(profileToUpdate, userResponse);
        return userService.save(profileToUpdate);
    }

    // implement delete using DELETE
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        userService.deleteById(id);
    }

    // TODO: use @RequestParam for a query param
    // http://localhost:8080/api/users?firstName=smith
//    @GetMapping
//    public void findByName(@RequestParam("firstName") String name) {
//        for (int i = 0; i < findAll().size(); i++) {
//            if (findAll().get(i).getFirstName().equals(name)) {
//                System.out.println("The details of the user " + name);
//                break;
//            } else {
//                System.out.println("User not found");
//            }
//        }
//    }
}
