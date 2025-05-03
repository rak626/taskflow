package com.rakesh.taskflow.repo;

import com.rakesh.taskflow.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, String> {

}
