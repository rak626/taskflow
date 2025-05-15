package com.rakesh.taskflow.repo;

import com.rakesh.taskflow.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface RoleRepo extends JpaRepository<Role, Long> {
    boolean existsByName(String name);

    Optional<Role> findByName(String roleName);

    List<Role> findByNameIn(Set<String> roles);
}
