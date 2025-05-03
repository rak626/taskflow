package com.rakesh.taskflow.service;

import com.rakesh.taskflow.entity.User;
import com.rakesh.taskflow.model.UserReq;

public interface UserService {
    User createUser(UserReq req);

    void updateUser(UserReq req);

    void deleteUser(String id);

    User getUserById(String id);

    void getAllUsers();

    void getUsersByEmail(String email);
}
