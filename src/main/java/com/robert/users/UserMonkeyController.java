package com.robert.users;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserMonkeyController {

    // TODO: 0. add logger and log messages in controller
    private final static Logger logger = LoggerFactory.getLogger(UserMonkeyController.class.getName());

    private UserMonkeyService userMonkeyService;

    @Autowired
    public UserMonkeyController(UserMonkeyService userMonkeyService) {
        this.userMonkeyService = userMonkeyService;
    }

    // find all
    @GetMapping
    public List<UserMonkey> findAll() {
        return userMonkeyService.findAll();
    }

    // TODO: 1. fix user CRUD
    //find one
    @GetMapping("/{id}")
    public UserMonkey findById(@PathVariable final Long id) {
        logger.debug("find by id {}", id);
        return userMonkeyService.findById(id);
    }

    //create
    @PostMapping
    public void create(UserMonkey userMonkey) {
        userMonkeyService.save(userMonkey);
    }

    //update
    @PutMapping
    public UserMonkey update(UserMonkey userMonkey) {
        return userMonkeyService.save(userMonkey);
    }

    //    //delete
    @DeleteMapping({"/id"})
    public void deleteById(Long id) {
        userMonkeyService.deleteById(id);
    }
}
