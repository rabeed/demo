package com.app.demo.controllers;

import com.app.demo.domain.User;
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
}
