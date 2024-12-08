package com.nickolas.blog.controllers;

import com.nickolas.blog.model.Post;
import com.nickolas.blog.service.PostService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PostController {
    @Autowired
    private PostService postService;


    @GetMapping("/")
    public String showForm(Model model) {
        model.addAttribute("post", new Post());
        return "form";
    }


    @PostMapping("/save")
    public String savePost(@ModelAttribute("post") Post post) {
        postService.savePost(post);
        return "redirect:/";
    }


    @GetMapping("/edit/{id}")
    public String editPost(@PathVariable("id") Long id, Model model) {
        Post post = postService.getPostById(id);
        model.addAttribute("post", post);
        return "form";
    }


    @GetMapping("/posts")
    public String showPosts(Model model) {
        model.addAttribute("posts", postService.getAllPosts());
        model.addAttribute("hasPosts", !postService.getAllPosts().isEmpty());
        return "posts";
    }


    @GetMapping("/posts/{id}")
    public String getPostById(@PathVariable("id") Long id, Model model) {
        Post post = postService.getPostById(id);
        if (post == null) {
            model.addAttribute("message", "Post not found!");
            return "error";
        }
        model.addAttribute("post", post);
        return "postDetails";
    }
}
