package com.stackoverflow.service;

import com.stackoverflow.entity.Answer;
import com.stackoverflow.entity.Question;
import com.stackoverflow.entity.User;
import com.stackoverflow.entity.Vote;
import com.stackoverflow.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    QuestionService questionService;

    @Autowired
    VoteService voteService;


    public List<User> retrieveUsers() {
        return (List<User>) userRepository.findAll();
    }

    public User retrieveUserById(Long cnp) {

        Optional<User> user = userRepository.findById(cnp);

        if(user.isPresent()) {
            return user.get();
        } else {
            return null;
        }
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(Long cnp) {
        userRepository.delete(retrieveUserById(cnp));

    }

    public User updateUser(User user) {
        return userRepository.save(user);
    }
}
