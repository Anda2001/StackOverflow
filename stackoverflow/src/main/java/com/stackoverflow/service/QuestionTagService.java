package com.stackoverflow.service;
import com.stackoverflow.repository.QuestionRepository;
import com.stackoverflow.repository.QuestionTagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.stackoverflow.entity.QuestionTag;

import java.util.List;

@Service
public class QuestionTagService {
    @Autowired
    QuestionTagRepository questionTagRepository;

    //read question_tags
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

}
