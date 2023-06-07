package com.stackoverflow.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "vote")
public class Vote {
    @Id
    @Column(name = "id")
    private Long voteId;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "user_id", referencedColumnName = "cnp", insertable = false, updatable = false)
//    private User user;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "cnp")
    private User user;

    @ManyToOne
    @JoinColumn(name = "question_id", referencedColumnName = "id")
    private Question question;

    @ManyToOne
    @JoinColumn(name = "answer_id", referencedColumnName = "id")
    private Answer answer;

    @Column(name = "vote_type")
    private boolean voteType;


    public Vote() {
    }

    public Vote(Long voteId, User user, Question question, boolean voteType, Answer answer) {
        this.voteId = voteId;
        this.user = user;
        this.question = question;
        this.voteType = voteType;
        this.answer = answer;
    }

    public Long getVoteId() {
        return voteId;
    }

    public void setVoteId(Long voteId) {
        this.voteId = voteId;
    }

//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public boolean getVoteType() {
        return voteType;
    }

    public void setVoteType(boolean voteType) {
        this.voteType = voteType;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }




}
