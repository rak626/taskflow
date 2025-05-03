package com.rakesh.taskflow.service.impl;

import com.rakesh.taskflow.entity.Todo;
import com.rakesh.taskflow.entity.User;
import com.rakesh.taskflow.exception.PlatformException;
import com.rakesh.taskflow.exception.ValidationException;
import com.rakesh.taskflow.model.TodoReq;
import com.rakesh.taskflow.repo.TodoRepo;
import com.rakesh.taskflow.service.TodoService;
import com.rakesh.taskflow.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService {

    private final TodoRepo todoRepo;
    private final UserService userService;


    @Override
    public Todo createTodo(TodoReq req) {
        validateRequest(req);
        User user = userService.getUserById(req.getUserId());
        Todo todo = Todo.builder()
                .title(req.getTitle())
                .description(req.getDescription())
                .label(req.getLabel())
                .priority(req.getPriority())
                .user(user)
                .dueAt(req.getDueAt())
                .build();
        return todoRepo.save(todo);

    }

    @Override
    public Todo updateTodo(TodoReq req) {
        return null;
    }

    @Override
    public void deleteTodo(String id, String userId) {

    }

    @Override
    public List<Todo> getTodosByUser(String userId) {
        return todoRepo.getTodosByUser(userId).orElse(List.of());
    }

    @Override
    public Todo getTodo(String id, String userId) {
        return todoRepo.getTodoByUser(id, userId)
                .orElseThrow(() -> new PlatformException("Todo not found"));
    }

    private void validateRequest(TodoReq req) {
        if (req.getTitle() == null || req.getTitle().isEmpty()) {
            throw new ValidationException("Title cannot be null or empty");
        }
        if (req.getDescription() == null || req.getDescription().isEmpty()) {
            throw new ValidationException("Description cannot be null or empty");
        }
        if (req.getLabel() == null) {
            throw new ValidationException("Label cannot be null or empty");
        }
        if (req.getPriority() == null) {
            throw new ValidationException("Priority cannot be null or empty");
        }
    }

}
