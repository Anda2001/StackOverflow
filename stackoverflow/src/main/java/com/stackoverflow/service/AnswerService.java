package com.stackoverflow.service;

import com.stackoverflow.entity.Answer;
import com.stackoverflow.repository.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerService {

    @Autowired
    AnswerRepository answerRepository;

    //read answers
    public List<Answer> retrieveAnswers() {
        return (List<Answer>) answerRepository.findAll();
    }

    //create answer
    public Answer createAnswer(Answer answer) {
        return answerRepository.save(answer);
    }

    //update answer
    public Answer updateAnswer(Answer answer) {
        return answerRepository.save(answer);
    }

    //delete answer
    public void deleteAnswer(Answer answer) {
        answerRepository.delete(answer);
    }


}
