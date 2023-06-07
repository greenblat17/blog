package com.greenblat.blog.service;

import com.greenblat.blog.model.Post;
import com.greenblat.blog.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;


    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public Post getPost(long id) {
        return postRepository.findById(id)
                .orElse(null);
    }
}
