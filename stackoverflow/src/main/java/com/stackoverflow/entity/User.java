package com.stackoverflow.entity;

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


    public User(Long userId, String firstName, String email, String password) {
        this.userId = userId;
        this.firstName = firstName;
        this.email = email;
        this.password = password;
    }

    public User() {

    }

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Question> questions = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
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

//    public List<Question> getQuestions() {
//        return questions;
//    }

//    public void setQuestions(Set<Question> questions) {
//        this.questions = questions;
//    }
//
//    public Set<Answer> getAnswers() {
//        return answers;
//    }
//
//    public void setAnswers(Set<Answer> answers) {
//        this.answers = answers;
//    }
//
//    public void addQuestion(Question question) {
//        questions.add(question);
//        question.setUser(this);
//    }
//
//    public void removeQuestion(Question question) {
//        questions.remove(question);
//        question.setUser(null);
//    }
//
//    public void addAnswer(Answer answer) {
//        answers.add(answer);
//        answer.setUser(this);
//    }
//
//    public void removeAnswer(Answer answer) {
//        answers.remove(answer);
//        answer.setUser(null);
//    }




    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", firstName='" + firstName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
