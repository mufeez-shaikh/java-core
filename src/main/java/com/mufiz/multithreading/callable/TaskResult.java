package com.mufiz.multithreading.callable;

import java.util.ArrayList;
import java.util.List;

// holds the result of the execution.
public class TaskResult {
    List<Integer> success = new ArrayList<>();
    List<Integer> failure = new ArrayList<>();

    public TaskResult(List<Integer> success, List<Integer> failure) {
        this.success = success;
        this.failure = failure;
    }

    public List<Integer> getSuccess() {
        return success;
    }

    public void setSuccess(List<Integer> success) {
        this.success = success;
    }

    public List<Integer> getFailure() {
        return failure;
    }

    public void setFailure(List<Integer> failure) {
        this.failure = failure;
    }
}
