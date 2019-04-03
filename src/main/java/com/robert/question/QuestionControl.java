package com.robert.question;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/question")
public class QuestionControl {


    private QuestionService questionService;

    @Autowired
    public QuestionControl(QuestionService questionService) {
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

    @GetMapping({"/id"})
    public Question findById(Long id) {
        return questionService.findById(id);
    }

    //update
    @PutMapping
    public Question update(Question question) {
        return questionService.save(question);
    }

    //delete
    @DeleteMapping({"/id"})
    public void deleteById(Long id) {
        questionService.deleteById(id);
    }
}
