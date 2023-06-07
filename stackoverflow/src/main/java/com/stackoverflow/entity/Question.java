package com.stackoverflow.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Blob;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    @JsonIgnore
    @OneToMany(mappedBy = "question")
    private Set<Answer> answers=new HashSet<>();

//    @ManyToMany
//    @JoinTable(
//            name = "question_tag",
//            joinColumns = @JoinColumn(name = "question_id"),
//            inverseJoinColumns = @JoinColumn(name = "tag_id"))
//    private List<Tag> tags;
    //use QuestionTag instead of Tag so you dont have to
// use the many to many relationship
    @JsonIgnore
    @OneToMany(mappedBy = "question")
    private Set<QuestionTag> questionTags = new HashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "question")
    private Set<Vote> votes = new HashSet<>();



    public Question() {
    }

    public Question(Long questionId, String title, String text, User user, Set<Answer> answers, Set<QuestionTag> questionTags, byte[] image, Set<Vote> votes) {
        this.questionId = questionId;
        this.title = title;
        this.text = text;
        this.user = user;
        this.answers = answers;
        this.image = image;
        this.questionTags = questionTags;
        this.votes = votes;
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


    public LocalTime getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(LocalTime creationTime) {
        this.creationTime = creationTime;
    }
    public Set<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(Set<Answer> answers) {
        this.answers = answers;
    }


    public Long getId() {
        return questionId;
    }

    public void setId(Long id) {
        this.questionId = id;
    }

    public Set<QuestionTag> getQuestionTags() {
        return questionTags;
    }

    public void setQuestionTags(Set<QuestionTag> questionTags) {
        this.questionTags = questionTags;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }


    public Set<Vote> getVotes() {
        return votes;
    }

    public void setVotes(Set<Vote> votes) {
        this.votes = votes;
    }

}
