package org.webler.springdemo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.webler.springdemo.model.User;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    List<User> users = new ArrayList<>();



    @GetMapping("/user")
    public List<User> listAllUsers() {
        return users;
    }

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable int id) {
        return users.get(id-1);
    }

    @PostMapping("/user")
    @ResponseStatus(HttpStatus.CREATED)
    public User createUser(@RequestBody User user) {
        users.add(user);
        return user;
    }


}
