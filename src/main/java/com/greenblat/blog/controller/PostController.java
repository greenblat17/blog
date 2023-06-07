package com.greenblat.blog.controller;

import com.greenblat.blog.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.nio.charset.StandardCharsets;

@Controller
@RequestMapping("/blog")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping
    public String showAllPosts(Model model) {
        model.addAttribute("posts", postService.getAllPosts());
        return "blog/index";
    }

    @GetMapping("/{id}")
    public String showOnePosts(@PathVariable Long id, Model model) {
        var post = postService.getPost(id);
        var content = new String(post.getContent(), StandardCharsets.UTF_8);

        model.addAttribute("post", post);
        model.addAttribute("content", content);

        return "blog/show";
    }

}
