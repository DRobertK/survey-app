package com.robert.user;

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
public class UserMonkeyController {

    // TODO: 0. add logger and log messages in controller
    private static final Logger logger = LoggerFactory.getLogger(UserMonkeyController.class.getName());

    private UserMonkeyService userMonkeyService;

    @Autowired
    public UserMonkeyController(UserMonkeyService userMonkeyService) {
        this.userMonkeyService = userMonkeyService;
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
    public List<UserMonkey> findAll() {
        return userMonkeyService.findAll();
    }

    // TODO: 1. fix user CRUD
    // find one
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
    @PatchMapping("/{id}")
    public UserMonkey partialUpdateUserMonkey(@RequestBody UserMonkeyDto userMonkeyDto, @PathVariable Long id) {

        UserMonkey userToUpdate = userMonkeyService.findById(id);
        map(userToUpdate, userMonkeyDto);
        return userMonkeyService.save(userToUpdate);
    }

    // delete

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        userMonkeyService.deleteById(id);
    }

    private void map(UserMonkey user, UserMonkeyDto dto) {
        user.setCity(dto.getCity());
        user.setCountry(dto.getCountry());
        user.setEmailAddress(dto.getEmailAddress());
    }
}
