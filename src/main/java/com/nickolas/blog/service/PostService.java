package com.nickolas.blog.service;

import com.nickolas.blog.model.Post;
import com.nickolas.blog.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository; // Репозиторій для роботи з базою даних


    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }


    public void savePost(Post post) {
        postRepository.save(post);
    }


    public Post getPostById(Long id) {
        return postRepository.findById(id).orElse(null);
    }
}
