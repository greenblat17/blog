package com.greenblat.blog.controller;

import com.greenblat.blog.model.Post;
import com.greenblat.blog.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/blog/user")
@RequiredArgsConstructor
public class UserController {

    private final PostService postService;

    @GetMapping("/create")
    public String createPostPage(@ModelAttribute Post post) {
        return "blog/user/create";
    }

    @PostMapping("/add")
    public String addPost(@ModelAttribute Post post) {
        postService.savePost(post);
        return "redirect:/blog";
    }
}
