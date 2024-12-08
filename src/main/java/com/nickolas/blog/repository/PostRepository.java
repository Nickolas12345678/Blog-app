package com.nickolas.blog.repository;

import com.nickolas.blog.model.Post;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class PostRepository {
    private final List<Post> posts = new ArrayList<>();

    public List<Post> findAll() {
        return new ArrayList<>(posts);
    }

    public Optional<Post> findBySlug(String slug) {
        return posts.stream().filter(post -> post.getSlug().equals(slug)).findFirst();
    }

    public Optional<Post> findById(Long id) {
        return posts.stream().filter(post -> post.getId().equals(id)).findFirst();
    }

    public void save(Post post) {
        if (post.getId() == null) {
            post.setId((long) (posts.size() + 1)); // Генерація ID
        }
        posts.add(post);
    }
}
