package com.stackoverflow.controller;


import com.stackoverflow.entity.Question;
import com.stackoverflow.entity.QuestionTag;
import com.stackoverflow.entity.Tag;
import com.stackoverflow.entity.User;
import com.stackoverflow.service.QuestionService;
import com.stackoverflow.service.QuestionTagService;
import com.stackoverflow.service.TagService;
import com.stackoverflow.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping( "/questions")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @Autowired
    QuestionTagService questionTagService;

    @Autowired
    TagService tagService;

    @Autowired
    UserService userService;

    //read questions
    //@CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/getAll")
    @ResponseBody
    public List<Question> retrieveQuestions(@RequestParam(value = "tag", required = false) Long tagId,
                                            @RequestParam(value = "user", required = false) Long userId,
                                            @RequestParam(value="title", required = false) String title) {
        List<Question> questions = questionService.retrieveQuestions();


        if (tagId != null) {
            Tag tag = tagService.retrieveTagById(tagId);
            questions = questionService.retrieveQuestionsByTag(tag);
        }
        if (userId != null) {
            User user = userService.retrieveUserById(userId);
            questions = questionService.retrieveQuestionsByUser(user);
        }
        if (title != null) {
            questions = questionService.retrieveQuestionsByText(title);
        }
        return questions;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/getById/{id}")
    @ResponseBody
    public Question retrieveQuestionById(@PathVariable("id") Long id) {
        return questionService.retrieveQuestionById(id);
    }

    @PostMapping("/create")
    @ResponseBody
    public Question createQuestion(@RequestBody Question question, @RequestParam("tags") String[] tags) {
        // Save the question
        Question savedQuestion = questionService.createQuestion(question);

        // Iterate over each tag
        for (String tag : tags) {
            // Search for the tag in the database
            Tag existingTag = tagService.retrieveTagByName(tag);

            // If the tag doesn't exist, create a new tag and save it
            if (existingTag == null) {
                Tag newTag = new Tag();
                newTag.setTitle(tag);
                existingTag = tagService.createTag(newTag);
            }

            // Create a new entry in the question-tag relationship table
            QuestionTag questionTag = new QuestionTag(savedQuestion, existingTag);
            questionTagService.createQuestionTag(questionTag);
        }

        // Return the saved question
        return savedQuestion;
    }

    //update question
    @PutMapping("/update")
    @ResponseBody
    public Question updateQuestion(@RequestBody Question question, @RequestParam("tags") String[] tags) {
        //get tags
        Set<QuestionTag> questionTags = questionTagService.retrieveQuestionTagsByQuestion(question);
        //delete tags
        if(questionTags != null){
            for (QuestionTag questionTag : questionTags) {
                questionTagService.deleteQuestionTag(questionTag);
            }
        }

        //create new tags
        for (String tag : tags) {
            // Search for the tag in the database
            Tag existingTag = tagService.retrieveTagByName(tag);

            // If the tag doesn't exist, create a new tag and save it
            if (existingTag == null) {
                Tag newTag = new Tag();
                newTag.setTitle(tag);
                existingTag = tagService.createTag(newTag);
            }

            // Create a new entry in the question-tag relationship table
            QuestionTag questionTag = new QuestionTag(question, existingTag);
            questionTagService.createQuestionTag(questionTag);
        }


        return questionService.updateQuestion(question);
    }

    //delete question
    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public void deleteQuestion(@PathVariable("id") Long id) {
        questionService.deleteQuestion(id);
    }





}
