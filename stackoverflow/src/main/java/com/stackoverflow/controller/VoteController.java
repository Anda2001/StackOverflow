package com.stackoverflow.controller;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.stackoverflow.entity.Vote;
import com.stackoverflow.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vote")
public class VoteController {

    @Autowired
    VoteService voteService;

    //read votes
    @GetMapping("/getAll")
    @ResponseBody
    public List<Vote> retrieveVotes() {
        return (List<Vote>) voteService.retrieveVotes();
    }

    //create vote
    @PostMapping("/create")
    @ResponseBody
    public Vote createVote(@RequestBody Vote vote){
        return voteService.createVote(vote);
    }

    //update vote
    @PutMapping("/update")
    @ResponseBody
    public Vote updateVote(@RequestBody Vote vote){
        return voteService.updateVote(vote);
    }

    //delete vote
    @DeleteMapping("/delete")
    @ResponseBody
    public void deleteVote(@RequestBody Vote vote){
        voteService.deleteVote(vote);
    }

    //vote count
    @JsonIgnore
    @GetMapping("/getVoteCountByQuestionId/{id}")
    @ResponseBody
    public Integer getVoteCountByQuestionId(@PathVariable int id){
        return voteService.getVoteCountByQuestionId(id);
    }

    //vote count by answer id
    @JsonIgnore
    @GetMapping("/getVoteCountByAnswerId/{id}")
    @ResponseBody
    public Integer getVoteCountByAnswerId(@PathVariable int id){
        return voteService.getVoteCountByAnswerId(id);
    }

    //get score for user
    @JsonIgnore
    @GetMapping("/getScore/{id}")
    @ResponseBody
    public Float getScoreByUserId(@PathVariable Long id){
        return voteService.getUserScore(id);
    }

}
