package org.webler.springdemo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.webler.springdemo.model.Post;
import org.webler.springdemo.model.User;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PostController {

    List<Post> posts = new ArrayList<>();

    @GetMapping("/post")
    public List<Post> listAllPosts() {
        return posts;
    }

    @GetMapping("/post/{id}")
    public Post getPost(@PathVariable int id) {
        return posts.get(id-1);
    }

    @PostMapping("/post")
    @ResponseStatus(HttpStatus.CREATED)
    public Post createPost(@RequestBody Post post) {
        posts.add(post);
        return post;
    }

}
