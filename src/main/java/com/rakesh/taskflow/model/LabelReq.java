package com.rakesh.taskflow.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LabelReq {
    private String name;
    private String color;
    private String userId;
}
