package com.vijaykumar.backendapi.service;

import com.vijaykumar.backendapi.model.Post;
import com.vijaykumar.backendapi.model.PostRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class PostService {

    private final List<Post> posts = new ArrayList<>();
    private long nextId = 1L;

    public List<Post> getAllPosts() {
        return Collections.unmodifiableList(posts);
    }

    public Post addPost(PostRequest request) {
        Post post = new Post(nextId++, request.getContent());
        posts.add(post);
        return post;
    }
}