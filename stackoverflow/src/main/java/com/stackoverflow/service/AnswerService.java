package com.stackoverflow.service;

import com.stackoverflow.entity.Answer;
import com.stackoverflow.repository.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnswerService {

    @Autowired
    AnswerRepository answerRepository;

    //read answers
    public void retrieveAnswers() {
        answerRepository.findAll();
    }

    //create answer
    public void createAnswer(Answer answer) {
        answerRepository.save(answer);
    }

    //update answer
    public void updateAnswer(Answer answer) {
        answerRepository.save(answer);
    }

    //delete answer
    public void deleteAnswer(Answer answer) {
        answerRepository.delete(answer);
    }


}
