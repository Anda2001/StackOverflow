package com.stackoverflow.controller;


import com.stackoverflow.entity.Question;
import com.stackoverflow.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping( "/questions")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    //read questions
    //@CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/getAll")
    @ResponseBody
    public List<Question> retrieveQuestions() {
        return questionService.retrieveQuestions();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/getById/{id}")
    @ResponseBody
    public Question retrieveQuestionById(@PathVariable("id") Long id) {
        return questionService.retrieveQuestionById(id);
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
    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public void deleteQuestion(@PathVariable("id") Long id) {
        questionService.deleteQuestion(id);
    }


}
