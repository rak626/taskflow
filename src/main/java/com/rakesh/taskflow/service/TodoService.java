package com.rakesh.taskflow.service;

import com.rakesh.taskflow.entity.Todo;
import com.rakesh.taskflow.model.TodoReq;

import java.util.List;

public interface TodoService {
    Todo createTodo(TodoReq req);

    Todo updateTodo(TodoReq req);

    void deleteTodo(String id, String userId);

    List<Todo> getTodosByUser(String userId);

    Todo getTodo(String id, String userId);
}
