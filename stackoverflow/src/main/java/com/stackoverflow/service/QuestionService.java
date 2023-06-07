package com.stackoverflow.service;


import com.stackoverflow.entity.*;
import com.stackoverflow.repository.QuestionRepository;
import com.stackoverflow.repository.QuestionTagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Service
public class QuestionService {

    @Autowired
    QuestionRepository questionRepository;

    @Autowired
    QuestionTagService questionTagService;

    @Autowired
    QuestionTagRepository questionTagRepository;

    @Autowired
    VoteService voteService;

    @Autowired
    AnswerService answerService;

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
        if(questionRepository.findById(question.getId()).isEmpty())
            return null;
        return questionRepository.save(question);
    }

    //delete question
    public void deleteQuestion(Long id) {
       //delete entrie from tagQuestion table
        List<QuestionTag> questionTags = questionTagService.retrieveQuestionTags();
        for (QuestionTag questionTag : questionTags) {
            if (questionTag.getQuestion().getId().equals(id)) {
                questionTagService.deleteQuestionTag(questionTag);
            }
        }
        //delete answers
        List<Answer> answers = answerService.retrieveAnswers();
        for (Answer answer : answers) {
            if (answer.getQuestion()!=null && answer.getQuestion().getId().equals(id)) {
                answerService.deleteAnswer(answer);
            }
        }

        //delete votes
        List<Vote> votes = voteService.retrieveVotes();
        for (Vote vote : votes) {
            if (vote.getQuestion()!=null && vote.getQuestion().getId().equals(id)) {
                voteService.deleteVote(vote);
            }
        }
        questionRepository.delete(retrieveQuestionById(id));
    }


    public List<Question> retrieveQuestionsWithTags() {
        List<Question> questions = (List<Question>) questionRepository.findAll();
        for (Question question : questions) {
            question.setQuestionTags(questionTagService.retrieveQuestionTagsByQuestion(question));
        }
        return questions;
    }

    public List<Question> retrieveQuestionsByTag(Tag tag) {
        List<Question> questions = retrieveQuestions();
        List<QuestionTag> questionTags = (List<QuestionTag>) questionTagRepository.findAll();
        List<Long> questionIds = new ArrayList<>();
        List<Question> questionTagsList = new ArrayList<>();

        for (QuestionTag questionTag : questionTags) {
            if (Objects.equals(questionTag.getTag().getTagId(), tag.getTagId())) {
                questionIds.add(questionTag.getQuestion().getQuestionId());
            }
        }

        for (Question question : questions) {
            if (questionIds.contains(question.getQuestionId())) {
                questionTagsList.add(question);
            }
        }

        return questionTagsList;
    }

    public List<Question> retrieveQuestionsByUser(User user) {
        List<Question> questions = retrieveQuestions();
        List<Question> userQuestions = new ArrayList<>();

        for (Question question : questions) {
            if (Objects.equals(question.getUser().getUserId(), user.getUserId())) {
                userQuestions.add(question);
            }
        }

        return userQuestions;
    }

    public List<Question> retrieveQuestionsByText(String title) {
        List<Question> questions = retrieveQuestions();
        List<Question> textQuestions = new ArrayList<>();

        for (Question question : questions) {
            if (question.getTitle().contains(title)) {
                textQuestions.add(question);
            }
        }

        return textQuestions;
    }
}
