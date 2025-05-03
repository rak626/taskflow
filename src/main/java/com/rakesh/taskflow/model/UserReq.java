package com.rakesh.taskflow.model;

import lombok.Data;

@Data
public class UserReq {
    private String name;
    private String email;
    private String phone;
    private String password;
}
