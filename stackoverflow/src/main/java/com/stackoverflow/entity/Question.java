package com.stackoverflow.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "question")
public class Question {
    @Id
    @Column(name = "id")
    private Long questionId;

    @Column(name = "title")
    private String title;

    @Column(name = "txt")
    private String text;

   @ManyToOne
    @JoinColumn(name = "author", referencedColumnName = "cnp")
   private User user;

    @Column(name = "creation_date")
    private String creationDate;

    @OneToMany(mappedBy = "question")
    private List<Answer> answers;

//    @ManyToMany
//    @JoinTable(
//            name = "question_tag",
//            joinColumns = @JoinColumn(name = "question_id"),
//            inverseJoinColumns = @JoinColumn(name = "tag_id"))
//    private List<Tag> tags;
    //use QuestionTag instead of Tag so you dont have to use the many to many relationship
    @OneToMany(mappedBy = "question")
    private List<QuestionTag> questionTags;



    public Question() {
    }

    public Question(Long questionId, String title, String text, User user, String creationDate, List<Answer> answers, List<Tag> tags) {
        this.questionId = questionId;
        this.title = title;
        this.text = text;
        this.user = user;
        this.creationDate = creationDate;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }


}
