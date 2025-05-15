package com.rakesh.taskflow.model;

import com.rakesh.taskflow.util.enums.Priority;
import lombok.Data;

import java.time.ZonedDateTime;

@Data
public class TodoReq {
    private String title;
    private String description;
    private String labelId;
    private Priority priority;
    private String userId;
    private String todoId;
    private ZonedDateTime dueAt;
}
