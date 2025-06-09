package com.priti.UserLookup.service.impl;

import com.priti.UserLookup.dto.CreateUserInput;
import com.priti.UserLookup.model.User;
import com.priti.UserLookup.repository.UserRepository;
import com.priti.UserLookup.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

     @Override
     public User createUser(CreateUserInput input) {
         User user = new User();
         user.setName(input.getName());
         user.setEmail(input.getEmail());
         return userRepository.save(user);
     }
    @Override
    public Optional<User> getUser(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Page<User> getUsersPaged(int page, int size) {
        return userRepository.findAll(PageRequest.of(page, size));
    }
}
