package org.webler.springdemo.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.webler.springdemo.model.User;

@RestController
public class GreetingController {


    @GetMapping("/greeting")
    public String greeting(@RequestParam(value = "name", defaultValue = "World") String name) {


        User user = new User("", "", "");
        System.out.println(user);

        return "Hello " + name + " from Get!";
    }

    @PostMapping("/greeting")
    public String greetingPost(@RequestParam(value = "name", defaultValue = "World") String name) {
        return "Hello " + name + " from Post!";
    }

}
