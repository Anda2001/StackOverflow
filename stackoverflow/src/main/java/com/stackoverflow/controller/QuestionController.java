package com.stackoverflow.controller;


import com.stackoverflow.entity.Question;
import com.stackoverflow.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( "/questions")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    //read questions
    @GetMapping("/getAll")
    @ResponseBody
    public List<Question> retrieveQuestions() {
        return questionService.retrieveQuestions();
    }

    //create question
    @PostMapping("/create")
    @ResponseBody
    public Question createQuestion( @RequestBody Question question) {
        return questionService.createQuestion(question);
    }

    //update question
    @PutMapping("/update")
    @ResponseBody
    public Question updateQuestion(@RequestBody Question question) {
        return questionService.updateQuestion(question);
    }

    //delete question
    @DeleteMapping("/delete")
    @ResponseBody
    public void deleteQuestion(@RequestBody Question question) {
        questionService.deleteQuestion(question);
    }


}
