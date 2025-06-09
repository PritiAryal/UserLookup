package com.priti.UserLookup.resolver;

import com.priti.UserLookup.exception.ResourceNotFoundException;
import com.priti.UserLookup.model.User;
import com.priti.UserLookup.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import java.util.List;

@Controller
@AllArgsConstructor
public class UserQueryResolver {
    private final UserService userService;

    @QueryMapping
    public User getUser(@Argument Long id) {
        return userService.getUser(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
    }

    @QueryMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @QueryMapping
    public List<User> getUsersPaged(@Argument int page, @Argument int size) {
        Page<User> usersPage = userService.getUsersPaged(page, size);
        return usersPage.getContent();  // return just the list of users
    }
}
