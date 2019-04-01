package com.robert.rest;


import com.robert.UserMonkey;
import com.robert.service.UserMonkeyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/userMonkey")
public class UserMonkeyControler {

    private UserMonkeyService userMonkeyService;

    public UserMonkeyControler(UserMonkeyService userMonkeyService) {
        this.userMonkeyService = userMonkeyService;
    }

    // find all
    @GetMapping
    public List<UserMonkey> findAll() {
        return userMonkeyService.findAll();
    }

    //find one
    @GetMapping
    public UserMonkey findById(Long id) {
        return userMonkeyService.findById(id);
    }

    //create
    @GetMapping
    public void create(UserMonkey userMonkey) {
        userMonkeyService.save(userMonkey);
    }

    //update
    @GetMapping
    public UserMonkey update(UserMonkey userMonkey) {
        return userMonkeyService.save(userMonkey);
    }

    //delete
    @GetMapping
    public void deleteById(Long id) {
        userMonkeyService.deleteById(id);
    }


}
