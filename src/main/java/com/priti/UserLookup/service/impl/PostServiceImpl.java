package com.priti.UserLookup.service.impl;

import com.priti.UserLookup.dto.CreatePostInput;
import com.priti.UserLookup.model.Post;
import com.priti.UserLookup.model.User;
import com.priti.UserLookup.repository.PostRepository;
import com.priti.UserLookup.repository.UserRepository;
import com.priti.UserLookup.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    @Override
    public Post createPost(CreatePostInput input) {
        User author = userRepository.findById(input.getAuthorId())
                .orElseThrow(() -> new IllegalArgumentException("User not found with ID: " + input.getAuthorId()));

        Post post = new Post();
        post.setTitle(input.getTitle());
        post.setContent(input.getContent());
        post.setAuthor(author);

        return postRepository.save(post);
    }

    @Override
    public List<Post> getPostsByAuthor(Long authorId) {
        return postRepository.findByAuthorId(authorId);
    }

    @Override
    public Optional<Post> getPost(Long id) {
        return postRepository.findById(id);
    }
}
