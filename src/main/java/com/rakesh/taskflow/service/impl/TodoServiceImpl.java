package com.rakesh.taskflow.service.impl;

import com.rakesh.taskflow.entity.Label;
import com.rakesh.taskflow.entity.Todo;
import com.rakesh.taskflow.entity.User;
import com.rakesh.taskflow.exception.PlatformException;
import com.rakesh.taskflow.exception.ValidationException;
import com.rakesh.taskflow.model.TodoReq;
import com.rakesh.taskflow.repo.TodoRepo;
import com.rakesh.taskflow.service.LabelService;
import com.rakesh.taskflow.service.TodoService;
import com.rakesh.taskflow.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService {

    private final TodoRepo todoRepo;
    private final UserService userService;
    private final LabelService levelService;


    @Override
    public Todo createTodo(TodoReq req) {
        validateRequest(req);
        User user = userService.getUserById(req.getUserId());
        Label label = Optional.ofNullable(req.getLabelId())
                .map(levelService::getLabelById).orElse(null);
        Todo todo = Todo.builder()
                .title(req.getTitle())
                .description(req.getDescription())
                .label(label)
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
        if (req.getUserId() == null || req.getUserId().isEmpty()) {
            throw new ValidationException("User ID cannot be null or empty");
        }
        if (req.getPriority() == null) {
            throw new ValidationException("Priority cannot be null or empty");
        }
    }

}
