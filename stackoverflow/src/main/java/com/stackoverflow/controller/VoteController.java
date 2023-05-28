package com.stackoverflow.controller;

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

}
