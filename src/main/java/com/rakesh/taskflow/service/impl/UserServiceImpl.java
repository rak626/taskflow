package com.rakesh.taskflow.service.impl;

import com.rakesh.taskflow.entity.Role;
import com.rakesh.taskflow.entity.User;
import com.rakesh.taskflow.exception.NoDataFoundException;
import com.rakesh.taskflow.exception.ValidationException;
import com.rakesh.taskflow.model.UserReq;
import com.rakesh.taskflow.repo.RoleRepo;
import com.rakesh.taskflow.repo.UserRepo;
import com.rakesh.taskflow.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;
    private final RoleRepo roleRepo;
    private final BCryptPasswordEncoder encoder;

    @Override
    public User createUser(UserReq req) {
        validateUser(req);

        User user = User.builder().name(req.getName())
                .email(req.getEmail())
                .phone(req.getPhone())
                .password(encoder.encode(req.getPassword()))
                .username(req.getUsername())
                .roles(getRolesFromRoleRepo(req.getRoles()))
                .enabled(true)
                .accountNonExpired(true)
                .accountNonLocked(true)
                .credentialsNonExpired(true)
                .build();
        return userRepo.save(user);
    }

    private Set<Role> getRolesFromRoleRepo(Set<String> roles) {
        if (roles == null || roles.isEmpty()) {
            return roleRepo.findByName("ROLE_USER")
                    .map(role -> new HashSet<>(Set.of(role))) // Defensive copy
                    .orElseGet(HashSet::new);
        }

        // Bulk fetch roles from DB
        List<Role> roleEntities = roleRepo.findByNameIn(roles);

        // Convert to map for quick lookup
        Map<String, Role> roleMap = roleEntities.stream()
                .collect(Collectors.toMap(Role::getName, Function.identity()));

        // Optionally: Log missing roles
        Set<String> missingRoles = roles.stream()
                .filter(role -> !roleMap.containsKey(role))
                .collect(Collectors.toSet());

        if (!missingRoles.isEmpty()) {
            log.error("Some roles not found in DB: {}", missingRoles);
            throw new NoDataFoundException("Invalid roles: " + missingRoles);
        }

        return new HashSet<>(roleMap.values());
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
