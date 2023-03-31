package com.stackoverflow.controller;


import com.stackoverflow.entity.User;
import com.stackoverflow.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( "/users")
public class UserController {

    @Autowired
    UserService userService;



    @GetMapping( "/getAll")
    @ResponseBody
    public List<User> retrieveUsers() {
        return userService.retrieveUsers();
    }


    @GetMapping("/getById")
    @ResponseBody
    public User retrieveById(){
        return userService.retrieveUserById(1L);
    }

    //create user
    @PostMapping("/create")
    @ResponseBody
    public User createUser(@RequestBody User user){
        return userService.createUser(user);
    }

    //update user
    @PutMapping("/update")
    @ResponseBody
    public User updateUser(@RequestBody User user){
        return userService.updateUser(user);
    }

    //delete user
    @DeleteMapping("/delete")
    @ResponseBody
    public void deleteUser(@RequestBody User user){
        userService.deleteUser(user);
    }


}