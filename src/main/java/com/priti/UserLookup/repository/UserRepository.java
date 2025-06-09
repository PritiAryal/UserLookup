package com.priti.UserLookup.repository;

import com.priti.UserLookup.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
