package com.stackoverflow.controller;

import com.stackoverflow.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/answers")
public class AnswerController {

    @Autowired
    AnswerService answerService;

    //read answers
    @GetMapping("/getAll")
    @ResponseBody
    public void retrieveAnswers() {
        answerService.retrieveAnswers();
    }

    //create answer
    @PostMapping("/create")
    @ResponseBody
    public void createAnswer() {
        answerService.createAnswer(null);
    }

    //update answer
    @PutMapping("/update")
    @ResponseBody
    public void updateAnswer() {
        answerService.updateAnswer(null);
    }

    //delete answer
    @DeleteMapping("/delete")
    @ResponseBody
    public void deleteAnswer() {
        answerService.deleteAnswer(null);
    }
}
