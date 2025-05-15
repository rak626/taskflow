package com.rakesh.taskflow.model;

import lombok.Data;

import java.util.Set;

@Data
public class UserReq {
    private String name;
    private String email;
    private String phone;
    private String password;
    private String username;
    private Set<String> roles;
}
