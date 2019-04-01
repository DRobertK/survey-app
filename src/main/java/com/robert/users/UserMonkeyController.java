package com.robert.users;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/userMonkey")
public class UserMonkeyController {

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

    //find one
    @GetMapping
    public UserMonkey findById(Long id) {
        return userMonkeyService.findById(id);
    }
//
//    //create
//    @PostMapping
//    public void create(UserMonkey userMonkey) {
//        userMonkeyService.save(userMonkey);
//    }
//
//    //update
//    @PutMapping
//    public UserMonkey update(UserMonkey userMonkey) {
//        return userMonkeyService.save(userMonkey);
//    }
//
//    //delete
//    @DeleteMapping
//    public void deleteById(Long id) {
//        userMonkeyService.deleteById(id);
//    }
}
