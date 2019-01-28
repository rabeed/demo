package com.app.demo.controllers;

import com.app.demo.domain.User;
import com.app.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    private List<User> users;


    @PostConstruct
    public void init() {
        users = new ArrayList<>();
        users.addAll(Arrays.asList(new User(1l, "user1", "user1")));
    }

    @GetMapping("/all")
    public List<User> getAllUsers() {
        return this.users;
    }

    @GetMapping("/allFromDb")
    public List<User> getUsersFromDb() {
        return userRepository.findAll();
    }

    @GetMapping("/add")
    public void addUser() {
        User u = new User();
        u.setName("name test");
        u.setLname("lname test");
        userRepository.save(u);
    }
}
