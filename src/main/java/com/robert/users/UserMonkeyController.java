package com.robert.users;

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
@RequestMapping(value = "/users")
public class UserMonkeyController {

    // TODO: 0. add logger and log messages in controller
    private final static Logger logger = LoggerFactory.getLogger(UserMonkeyController.class.getName());

    private UserMonkeyService userMonkeyService;

    @Autowired
    public UserMonkeyController(UserMonkeyService userMonkeyService) {
        this.userMonkeyService = userMonkeyService;
    }

    //ResponseParam and ResponseEntity
    @GetMapping("/userInfo")
    ResponseEntity<String> ageUser(
            @RequestParam("yearOfBirth") LocalDate yearOfBirth) {
        LocalDate curentDate = LocalDate.now();
        if (Period.between(yearOfBirth, curentDate).getYears() > 0) {
            return new ResponseEntity<>("You've been born in: " + yearOfBirth
                    , HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Wrong value", HttpStatus.BAD_REQUEST);
        }
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

    // create
    @PostMapping
    public void create(@RequestBody UserMonkey userMonkey) {
        userMonkeyService.save(userMonkey);
    }

    // update
    @PutMapping
    public UserMonkey update(@RequestBody UserMonkey userMonkey) {
        return userMonkeyService.save(userMonkey);
    }

    // TODO: replace with PATCH
    @PatchMapping("/usermonkey/{id}")
    public UserMonkey partialUpdateUserMonkey(@RequestBody UserMonkeyDto userMonkeyDto, @PathVariable Long id) {

        UserMonkey userToUpdate = userMonkeyService.findById(id);
        userToUpdate.setCity(userMonkeyDto.getCity());
        userToUpdate.setCountry(userMonkeyDto.getCountry());
        userToUpdate.setEmailAddress(userMonkeyDto.getEmailAddress());
        return userMonkeyService.save(userToUpdate);
    }

    // delete
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        userMonkeyService.deleteById(id);
    }
}
