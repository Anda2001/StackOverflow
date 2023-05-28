package com.stackoverflow.controller;

import com.stackoverflow.entity.Answer;
import com.stackoverflow.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/answers")
public class AnswerController {

    @Autowired
    AnswerService answerService;

    //read answers
    @GetMapping("/getAll")
    @ResponseBody
    public List<Answer> retrieveAnswers() {
        return answerService.retrieveAnswers();
    }

    //create answer
    @PostMapping("/create")
    @ResponseBody
    public Answer createAnswer(@RequestBody Answer answer){
        return answerService.createAnswer(answer);
    }

    //update answer
    @PutMapping("/update")
    @ResponseBody
    public Answer updateAnswer(@RequestBody Answer answer) {
        return answerService.updateAnswer(answer);
    }

    //delete answer
    @DeleteMapping("/delete")
    @ResponseBody
    public void deleteAnswer(@RequestBody Answer answer) {
        answerService.deleteAnswer(answer);
    }
}
