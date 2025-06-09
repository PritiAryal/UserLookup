package com.priti.UserLookup.service;

import com.priti.UserLookup.dto.CreatePostInput;
import com.priti.UserLookup.model.Post;

import java.util.List;
import java.util.Optional;

public interface PostService {
    Post createPost(CreatePostInput input);
    List<Post> getPostsByAuthor(Long authorId);
    Optional<Post> getPost(Long id);
}
