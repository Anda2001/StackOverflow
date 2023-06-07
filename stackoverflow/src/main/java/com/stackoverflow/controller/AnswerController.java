package com.stackoverflow.controller;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
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
    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public void deleteAnswer(@PathVariable Long id) {
        List<Answer> answers = answerService.retrieveAnswers();
        for (Answer answer : answers) {
            if (answer.getAnswerId().equals(id)) {
                answerService.deleteAnswer(answer);
                break;
            }
        }
    }

    //get answers by question
    @GetMapping("/getByQuestion/{id}")
    @ResponseBody
    public List<Answer> retrieveAnswersByQuestion(@PathVariable("id") Long id) {
        return answerService.retrieveAnswersByQuestion(id);
    }
}
