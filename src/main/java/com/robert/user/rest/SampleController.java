package com.robert.user.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.Period;

public class SampleController {

    @GetMapping("/hello")
    ResponseEntity<String> hello() {
        return new ResponseEntity<>("Hello World", HttpStatus.OK);
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
}
