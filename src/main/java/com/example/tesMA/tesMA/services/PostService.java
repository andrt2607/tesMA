package com.example.tesMA.tesMA.services;

import java.util.List;
import java.util.UUID;

import com.example.tesMA.tesMA.models.Post;

public interface PostService {
    List<Post> getAllPosts();
    Post createPost(Post post);
    Post updatePost(Post post);
    void deletePost(UUID id);
    Post getPostById(UUID id);
}
