package com.stackoverflow.service;

import com.stackoverflow.entity.Vote;
import com.stackoverflow.repository.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

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
        List<Vote> votes = retrieveVotes();
        for(Vote v : votes) {
            System.out.println(v.getQuestion());
            if (v.getQuestion() != null  && v.getQuestion().getQuestionId() != null) {
                if (vote.getQuestion() != null && Objects.equals(v.getQuestion().getQuestionId(), vote.getQuestion().getQuestionId()) && Objects.equals(v.getUser().getUserId(), vote.getUser().getUserId())) {
                    return null;
                }
            }
            if (v.getAnswer() != null && v.getAnswer().getAnswerId() != null) {
                if (vote.getAnswer() != null && Objects.equals(v.getAnswer().getAnswerId(), vote.getAnswer().getAnswerId()) && Objects.equals(v.getUser().getUserId(), vote.getUser().getUserId())) {
                    return null;
                }
            }
        }
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

    public Integer retrieveLikesByQuestionId(int id) {
        List<Vote> votes = retrieveVotes();
        int count = 0;
        for (Vote vote : votes) {
            if(vote.getQuestion()!=null){
                if (vote.getQuestion().getQuestionId() == id && vote.getVoteType()) {
                    count++;
                }
            }
        }
        return count;
    }

    public Integer retrieveDislikesByQuestionId(int id) {
        List<Vote> votes = retrieveVotes();
        int count = 0;
        for (Vote vote : votes) {
            if(vote.getQuestion()!=null){
                if (vote.getQuestion().getQuestionId() == id && !vote.getVoteType()) {
                    count++;
                }
            }

        }
        return count;
    }

    public Integer getVoteCountByQuestionId(int id) {
        List<Vote> votes = retrieveVotes();
        int count = 0;
        for (Vote vote : votes) {
            if (vote.getQuestion()!=null){
                if( vote.getQuestion().getQuestionId() == id) {
                    count = retrieveLikesByQuestionId(id) - retrieveDislikesByQuestionId(id);
                }
            }
        }
        return count;
    }

    public Integer getVoteCountByAnswerId(int id) {
        List<Vote> votes = retrieveVotes();
        int count = 0;
        for (Vote vote : votes) {
            if(vote.getAnswer()!=null){
                if (vote.getAnswer().getAnswerId() == id) {
                    count = retrieveLikesByAnswerId(id) - retrieveDislikesByAnswerId(id);
                }
            }

        }
        return count;
    }

    public Integer retrieveLikesByAnswerId(int id) {
        List<Vote> votes = retrieveVotes();
        int count = 0;
        for (Vote vote : votes) {
            if(vote.getAnswer()!=null){
                if (vote.getAnswer().getAnswerId() == id && vote.getVoteType()) {
                    count++;
                }
            }
        }
        return count;
    }

    public Integer retrieveDislikesByAnswerId(int id) {
        List<Vote> votes = retrieveVotes();
        int count = 0;
        for (Vote vote : votes) {
            if(vote.getAnswer()!=null){
                if (vote.getAnswer().getAnswerId() == id && !vote.getVoteType()) {
                    count++;
                }
            }
        }
        return count;
    }

    public Float getUserScore(Long id){
        List<Vote> votes = retrieveVotes();
        Float score = 0f;
        for (Vote vote : votes) {
            if(vote.getUser()!=null){
                if (vote.getUser().getUserId().equals(id)) {
                    if(!vote.getVoteType()){
                        score= (float) (score-1.5);
                    }

                }
            }
            if(vote.getQuestion()!=null){
                if (vote.getQuestion().getUser().getUserId().equals(id)) {
                    if(vote.getVoteType()){
                        score= (float) (score+2.5);
                    }else{
                        score= (float) (score-1.5);
                    }
                }
            }

            if(vote.getAnswer()!=null){
                if (vote.getAnswer().getUser().getUserId().equals(id)) {
                    if(vote.getVoteType()){
                        score= (float) (score+5);
                    }else{
                        score= (float) (score-2.5);
                    }
                }
            }
        }
        return score;

    }


}
