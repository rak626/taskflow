package com.rakesh.taskflow.util.enums;

public enum Status {
    SUCCESS,
    ERROR,
    WARNING,
    INFO,
    FATAL,
    PENDING,
    IN_PROGRESS,
    COMPLETED,
    CANCELLED,
    TIMEOUT,
    UNKNOWN;

    public static Status fromString(String status) {
        try {
            return Status.valueOf(status.toUpperCase());
        } catch (IllegalArgumentException e) {
            return UNKNOWN;
        }
    }
}
