package com.rakesh.taskflow.controller;

import com.rakesh.taskflow.entity.Todo;
import com.rakesh.taskflow.model.Response;
import com.rakesh.taskflow.model.TodoReq;
import com.rakesh.taskflow.service.TodoService;
import com.rakesh.taskflow.util.ResponseUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1.0/todo")
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @PostMapping("/create")
    public ResponseEntity<Response<Todo>> createTodo(@RequestBody TodoReq req) {
        return ResponseUtil.prepareResponse(todoService.createTodo(req));
    }

    @PutMapping("/update")
    public ResponseEntity<Response<Todo>> updateTodo(@RequestBody TodoReq req) {
        return ResponseUtil.prepareResponse(todoService.updateTodo(req));
    }

    @GetMapping
    public ResponseEntity<Response<List<Todo>>> getTodo(@RequestParam String userId) {
        return ResponseUtil.prepareResponse(todoService.getTodosByUser(userId));
    }

}
