package com.priti.UserLookup.service;

import com.priti.UserLookup.dto.CreateUserInput;
import com.priti.UserLookup.model.User;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User createUser(CreateUserInput input);
    Optional<User> getUser(Long id);
    List<User> getAllUsers();
    Page<User> getUsersPaged(int page, int size);
}
