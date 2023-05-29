package com.stackoverflow.service;


import com.stackoverflow.entity.Question;
import com.stackoverflow.entity.User;
import com.stackoverflow.repository.QuestionRepository;
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

    public Question retrieveQuestionById(Long id) {
        if(questionRepository.findById(id).isEmpty())
            return null;
        return questionRepository.findById(id).get();
    }

    //create question
    public Question createQuestion(Question question) {
        if(questionRepository.findById(question.getId()).isPresent())
            return null;
       return questionRepository.save(question);
    }

    //update question
    public Question updateQuestion(Question question) {
        return questionRepository.save(question);
    }

    //delete question
    public void deleteQuestion(Long id) {
       questionRepository.delete(retrieveQuestionById(id));
    }


}
