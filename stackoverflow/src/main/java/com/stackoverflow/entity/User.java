package com.stackoverflow.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "person")
public class User {

    @Id
    @Column(name="cnp")
    private Long userId;


    @Column(name = "f_name")
    private String firstName;

    @Column(name = "e_mail")
    private String email;

    @Column(name = "passw")
    private String password;

    @Column(name = "banned")
    private boolean banned;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<Vote> votes = new ArrayList<>();


    public User(Long userId, String firstName, String email, String password, List<Question> questions, Set<Answer> answers, List<Vote> votes, boolean banned) {
        this.userId = userId;
        this.firstName = firstName;
        this.email = email;
        this.password = password;
        this.questions = questions;
        this.answers = answers;
        this.votes = votes;
        this.banned = banned;
    }

    public User() {

    }

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<Question> questions = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private Set<Answer> answers = new HashSet<>();


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Vote> getVotes() {
        return votes;
    }

    public void setVotes(List<Vote> votes) {
        this.votes = votes;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public Set<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(Set<Answer> answers) {
        this.answers = answers;
    }

    public boolean getBanned() {
    	return banned;
    }

    public void setBanned(boolean banned) {
    	this.banned = banned;
    }






    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", firstName='" + firstName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
