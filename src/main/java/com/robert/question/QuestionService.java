package com.robert.question;

import com.robert.question.domain.Question;
import com.robert.question.domain.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    private QuestionRepository questionRepository;

    @Autowired
    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public Question save(Question question) {
        return questionRepository.save(question);
    }

    public List<Question> findAll() {
        return questionRepository.findAll();
    }

    public Question findById(long id) {
        return questionRepository.findById(id).orElseThrow(() -> new IllegalArgumentException());
    }


    public void deleteById(long id) {
        questionRepository.deleteById(id);
    }

//    public void add(Question question) {
//        questionRepository.save(question);
//    }
}
