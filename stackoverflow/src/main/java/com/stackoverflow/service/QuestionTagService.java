package com.stackoverflow.service;
import com.stackoverflow.entity.Question;
import com.stackoverflow.entity.Tag;
import com.stackoverflow.repository.QuestionRepository;
import com.stackoverflow.repository.QuestionTagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.stackoverflow.entity.QuestionTag;

import java.util.List;
import java.util.Set;

@Service
public class QuestionTagService {
    @Autowired
    QuestionTagRepository questionTagRepository;

    @Autowired
    QuestionRepository questionRepository;

    //read question_tags
    public List<Question> retrieveQuestionsWithTags() {
        List<Question> questions = (List<Question>) questionRepository.findAll();
        for (Question question : questions) {
            question.setQuestionTags(retrieveQuestionTagsByQuestion(question));
        }
        return questions;
    }

    public List<QuestionTag> retrieveQuestionTags() {
        return (List<QuestionTag>) questionTagRepository.findAll();
    }

    //create question_tag
    public QuestionTag createQuestionTag(QuestionTag questionTag) {
        return questionTagRepository.save(questionTag);
    }

    //update question_tag
    public QuestionTag updateQuestionTag(QuestionTag questionTag) {
        return questionTagRepository.save(questionTag);
    }

    //delete question_tag
    public void deleteQuestionTag(QuestionTag questionTag) {
        questionTagRepository.delete(questionTag);
    }

    public Set<QuestionTag> retrieveQuestionTagsByQuestion(Question question) {
        List<QuestionTag> questionTags= retrieveQuestionTags();
        for (QuestionTag questionTag : questionTags) {
            if (questionTag.getQuestion().getId().equals(question.getId())) {
                return question.getQuestionTags();
            }
        }
        return null;
    }

    public Set<QuestionTag> retrieveQuestionTagsByTag(Tag tag) {
        List<QuestionTag> questionTags= retrieveQuestionTags();
        for (QuestionTag questionTag : questionTags) {
            if (questionTag.getTag().getTagId().equals(tag.getTagId())) {
                return tag.getQuestionTags();
            }
        }
        return null;
    }


}
