package com.rakesh.taskflow.controller;

import com.rakesh.taskflow.entity.User;
import com.rakesh.taskflow.model.Response;
import com.rakesh.taskflow.model.UserReq;
import com.rakesh.taskflow.service.UserService;
import com.rakesh.taskflow.util.ResponseUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1.0")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<Response<User>> register(@RequestBody UserReq req) {
        return ResponseUtil.prepareResponse(userService.createUser(req));
    }
}
