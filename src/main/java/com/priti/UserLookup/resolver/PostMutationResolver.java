package com.priti.UserLookup.resolver;

import com.priti.UserLookup.dto.CreatePostInput;
import com.priti.UserLookup.model.Post;
import com.priti.UserLookup.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

@Controller
@AllArgsConstructor
public class PostMutationResolver {
    private final PostService postService;

    @MutationMapping
    public Post createPost(@Argument CreatePostInput input) {
        return postService.createPost(input);
    }
}
