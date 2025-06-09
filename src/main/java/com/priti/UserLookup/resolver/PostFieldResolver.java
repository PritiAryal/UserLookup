package com.priti.UserLookup.resolver;

import com.priti.UserLookup.model.Post;
import com.priti.UserLookup.model.User;
//import com.priti.UserLookup.service.UserService;
//import lombok.AllArgsConstructor;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

@Controller
//@AllArgsConstructor
public class PostFieldResolver {
//    private final UserService userService;

    @SchemaMapping(typeName = "Post", field = "author")
    public User resolveAuthor(Post post){
        return post.getAuthor();//Post entity already has a properly mapped User author so not needed in this example so this whole class can be skipped.
    }
}
