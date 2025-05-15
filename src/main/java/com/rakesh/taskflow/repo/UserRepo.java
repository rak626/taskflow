package com.rakesh.taskflow.repo;

import com.rakesh.taskflow.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, String> {

    Optional<User> findByUsername(String username);
}
