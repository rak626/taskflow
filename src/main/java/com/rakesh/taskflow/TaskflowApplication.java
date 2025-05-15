package com.rakesh.taskflow;

import com.rakesh.taskflow.entity.Role;
import com.rakesh.taskflow.repo.RoleRepo;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Set;

@SpringBootApplication
public class TaskflowApplication {

    @Autowired
    private RoleRepo roleRepo;

    public static void main(String[] args) {
        SpringApplication.run(TaskflowApplication.class, args);
    }


    @PostConstruct
    public void seedRoles() {
        Set<Role> roles = Set.of(Role.builder().name("ROLE_USER").description("user role").build(),
                Role.builder().name("ROLE_ADMIN").description("admin role").build(),
                Role.builder().name("ROLE_MODERATOR").description("moderator role").build(),
                Role.builder().name("ROLE_SUPER_ADMIN").description("super admin role").build());
        roles.forEach(role -> {
            if (!roleRepo.existsByName(role.getName())) {
                roleRepo.save(role);
            }
        });
    }

}
