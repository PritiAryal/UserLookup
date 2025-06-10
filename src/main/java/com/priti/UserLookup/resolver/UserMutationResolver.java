package com.priti.UserLookup.resolver;

import com.priti.UserLookup.dto.CreateUserInput;
import com.priti.UserLookup.model.User;
import com.priti.UserLookup.service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

@Controller
@AllArgsConstructor
public class UserMutationResolver {
    private final UserService userService;

    @MutationMapping
    public User createUser(@Valid @Argument CreateUserInput input) {
        return userService.createUser(input);
    }
}
