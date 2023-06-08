package com.greenblat.blog.service;

import com.greenblat.blog.model.Post;
import com.greenblat.blog.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional(readOnly = true)
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

    @Transactional
    public Post savePost(Post post) {
        post.setCreatedAt(LocalDate.now());
        return postRepository.save(post);
    }
}
