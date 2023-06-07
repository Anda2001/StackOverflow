package com.stackoverflow.service;

import com.stackoverflow.entity.Answer;
import com.stackoverflow.entity.Vote;
import com.stackoverflow.repository.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AnswerService {

    @Autowired
    AnswerRepository answerRepository;

    @Autowired
    VoteService voteService;

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
        //delete votes for answer
        List<Vote> votes = voteService.retrieveVotes();
        for (Vote vote : votes) {
            if(vote.getAnswer()!=null){
                if (vote.getAnswer().getAnswerId().equals(answer.getAnswerId())) {
                    voteService.deleteVote(vote);
                }
            }
        }

        answerRepository.delete(answer);
    }


    public List<Answer> retrieveAnswersByQuestion(Long id) {
        List<Answer> answers = retrieveAnswers();
        List<Answer> answersByQuestion = new ArrayList<>();
        for (Answer answer : answers) {
            if (answer.getQuestion().getId().equals(id)) {
                answersByQuestion.add(answer);
            }
        }
        return answersByQuestion;
    }
}
