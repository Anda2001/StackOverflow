package com.stackoverflow.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Blob;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
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
//
    @Column(name = "creation_date")
    private LocalDate creationDate = LocalDate.now();

    @Column(name="creation_time")
    private LocalTime creationTime = LocalTime.now();

    @Column(name="image")
    private byte[] image;

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

    public Question(Long questionId, String title, String text, User user, List<Answer> answers, List<QuestionTag> questionTags, byte[] image) {
        this.questionId = questionId;
        this.title = title;
        this.text = text;
        this.user = user;
        this.answers = answers;
        this.image = image;
        this.questionTags = questionTags;

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

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }


    public Long getId() {
        return questionId;
    }

    public void setId(Long id) {
        this.questionId = id;
    }

    public List<QuestionTag> getQuestionTags() {
        return questionTags;
    }

    public void setQuestionTags(List<QuestionTag> questionTags) {
        this.questionTags = questionTags;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
