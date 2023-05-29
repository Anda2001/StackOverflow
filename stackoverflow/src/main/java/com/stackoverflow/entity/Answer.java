package com.stackoverflow.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "answer")
public class Answer {

    @Id
    @Column(name = "id")
    private Long answerId;

    @Column(name = "txt")
    private String text;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "cnp")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id")
    private Question question;

//    @Column(name = "creation_date")
//    private String creationDate;

    public Answer() {
    }

    public Answer(Long answerId, String text, User user, Question question, String creationDate) {
        this.answerId = answerId;
        this.text = text;
        this.user = user;
        this.question = question;
       // this.creationDate = creationDate;
    }

    public Long getAnswerId() {
        return answerId;
    }

    public void setAnswerId(Long answerId) {
        this.answerId = answerId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

//    public String getCreationDate() {
//        return creationDate;
//    }
//
//    public void setCreationDate(String creationDate) {
//        this.creationDate = creationDate;
//    }

    @Override
    public String toString() {
        return "Answer{" +
                "answerId=" + answerId +
                ", text='" + text + '\'' +
                ", user=" + user +
                ", question=" + question +
                '}';
    }

}
