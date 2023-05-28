package com.stackoverflow.service;

import com.stackoverflow.entity.Vote;
import com.stackoverflow.repository.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoteService {

    @Autowired
    VoteRepository voteRepository;

    //read votes
    public List<Vote> retrieveVotes() {
        return (List<Vote>) voteRepository.findAll();
    }

    //create vote
    public Vote createVote(Vote vote) {
        return voteRepository.save(vote);
    }

    //update vote
    public Vote updateVote(Vote vote) {
        return voteRepository.save(vote);
    }

    //delete vote
    public void deleteVote(Vote vote) {
        voteRepository.delete(vote);
    }
}
