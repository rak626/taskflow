package com.rakesh.taskflow.repo;

import com.rakesh.taskflow.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TodoRepo extends JpaRepository<Todo, UUID> {

    @Query("SELECT t FROM Todo t WHERE t.userId = ?1")
    Optional<List<Todo>> getTodosByUser(String userId);

    @Query("SELECT t FROM Todo t WHERE t.id = ?1 AND t.userId = ?2")
    Optional<Todo> getTodoByUser(String id, String userId);
}
