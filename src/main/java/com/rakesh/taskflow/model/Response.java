package com.rakesh.taskflow.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.rakesh.taskflow.util.enums.Status;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response<T> {
    public Status status;
    public T result;
    public List<Error> errors = new ArrayList<>();
}
