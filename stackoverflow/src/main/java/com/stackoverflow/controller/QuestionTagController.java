package com.stackoverflow.controller;

import com.stackoverflow.entity.QuestionTag;
import com.stackoverflow.service.AnswerService;
import com.stackoverflow.service.QuestionTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question_tags")

public class QuestionTagController {
    @Autowired
    QuestionTagService questionTagService;

    //read question_tags
    @GetMapping("/getAll")
    @ResponseBody
    public List<QuestionTag> retrieveQuestionTags() {
        return questionTagService.retrieveQuestionTags();
    }

    //create question_tag
    @PostMapping("/create")
    @ResponseBody
    public QuestionTag createQuestionTag(@RequestBody QuestionTag questionTag){
        return questionTagService.createQuestionTag(questionTag);
    }

    //update question_tag
    @PutMapping("/update")
    @ResponseBody
    public QuestionTag updateQuestionTag(@RequestBody QuestionTag questionTag){
        return questionTagService.updateQuestionTag(questionTag);
    }

    //delete question_tag
    @DeleteMapping("/delete")
    @ResponseBody
    public void deleteQuestionTag(@RequestBody QuestionTag questionTag){
        questionTagService.deleteQuestionTag(questionTag);
    }


}
