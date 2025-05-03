package com.rakesh.taskflow.model;

import com.rakesh.taskflow.entity.Label;
import com.rakesh.taskflow.util.enums.Priority;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TodoReq {
    private String title;
    private String description;
    private Label label;
    private Priority priority;
    private String userId;
    private String todoId;
    private String status;
    private LocalDateTime dueAt;
}
