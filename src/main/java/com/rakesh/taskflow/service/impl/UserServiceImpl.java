package com.rakesh.taskflow.service.impl;

import com.rakesh.taskflow.entity.User;
import com.rakesh.taskflow.exception.NoDataFoundException;
import com.rakesh.taskflow.exception.ValidationException;
import com.rakesh.taskflow.model.UserReq;
import com.rakesh.taskflow.repo.UserRepo;
import com.rakesh.taskflow.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;

    @Override
    public User createUser(UserReq req) {
        validateUser(req);

        User user = User.builder().name(req.getName())
                .email(req.getEmail())
                .phone(req.getPhone())
                .password(req.getPassword())
                .build();
        return userRepo.save(user);
    }

    private void validateUser(UserReq req) {
        if (req.getName() == null || req.getEmail() == null || req.getPhone() == null || req.getPassword() == null) {
            throw new ValidationException("All fields are required");
        }
    }

    @Override
    public void updateUser(UserReq req) {

    }

    @Override
    public void deleteUser(String id) {

    }

    @Override
    public User getUserById(String id) {
        return userRepo.findById(id)
                .orElseThrow(() -> new NoDataFoundException("User not found"));
    }

    @Override
    public void getAllUsers() {

    }

    @Override
    public void getUsersByEmail(String email) {

    }
}
