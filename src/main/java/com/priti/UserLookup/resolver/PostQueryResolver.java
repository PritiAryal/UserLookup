package com.priti.UserLookup.resolver;

import com.priti.UserLookup.model.Post;
import com.priti.UserLookup.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@AllArgsConstructor
public class PostQueryResolver {
    private final PostService postService;

    @QueryMapping
    public List<Post> getPostsByUser(@Argument Long userId) {
        return postService.getPostsByAuthor(userId);
    }

    @QueryMapping
    public Post getPost(@Argument Long id) {
        return postService.getPost(id)
                .orElseThrow(() -> new RuntimeException("Post not found with id: " + id));
    }
}
