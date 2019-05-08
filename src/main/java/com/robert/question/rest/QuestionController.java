package com.robert.question.rest;

import com.robert.question.QuestionService;
import com.robert.question.domain.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/question")
public class QuestionController {


    private QuestionService questionService;

    @Autowired
    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    //create
    @PostMapping
    public Question save(Question question) {
        return questionService.save(question);
    }

    //read
    @GetMapping
    public List<Question> findAll() {
        return questionService.findAll();
    }

    @GetMapping("/{id}")
    public Question findById(@PathVariable Long id) {
        return questionService.findById(id);
    }

    //update
    @PutMapping
    public Question update(Question question) {
        return questionService.save(question);
    }

    //delete
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        questionService.deleteById(id);
    }
}
