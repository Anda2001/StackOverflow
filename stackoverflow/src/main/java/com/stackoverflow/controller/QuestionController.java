package com.stackoverflow.controller;


import com.stackoverflow.entity.Question;
import com.stackoverflow.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping( "/questions")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    //read questions
    @GetMapping( "/getAll")
    @ResponseBody
    public void retrieveQuestions() {
        questionService.retrieveQuestions();
    }

    //create question
    @PostMapping( "/create")
    @ResponseBody
    public void createQuestion(@RequestBody Question question){
        questionService.createQuestion(question);
    }

    //update question
    @PutMapping( "/update")
    @ResponseBody
    public void updateQuestion(@RequestBody Question question){
        questionService.updateQuestion(question);
    }

    //delete question
    @DeleteMapping( "/delete")
    @ResponseBody
    public void deleteQuestion(@RequestBody Question question){
        questionService.deleteQuestion(question);
    }
}
