package com.stackoverflow.service;


import com.stackoverflow.entity.Question;
import com.stackoverflow.repository.QuestionRepository;
import com.stackoverflow.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionRepository questionRepository;

    //read questions
    public List<Question> retrieveQuestions() {
        return (List<Question>) questionRepository.findAll();
    }

    //create question
    public void createQuestion(Question question) {
        questionRepository.save(question);
    }

    //update question
    public void updateQuestion(Question question) {
        questionRepository.save(question);
    }

    //delete question
    public void deleteQuestion(Question question) {
        questionRepository.delete(question);
    }
}
