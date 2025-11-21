package com.vijaykumar.backendapi.controller;

import com.vijaykumar.backendapi.model.Post;
import com.vijaykumar.backendapi.model.PostRequest;
import com.vijaykumar.backendapi.service.PostService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
@CrossOrigin(origins = "*")   // allows Android app to call from emulator
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public List<Post> getPosts() {
        return postService.getAllPosts();
    }

    @PostMapping
    public Post createPost(@Valid @RequestBody PostRequest request) {
        return postService.addPost(request);
    }
}