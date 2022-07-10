package com.zvezdilin.MethodOfCountingEmployees.entites;

public class Task {
    private String task_id;
    private String assignee_id;
    private State task_state;

    public Task(String task_id, String assignee_id, State task_state) {
        this.task_id = task_id;
        this.assignee_id = assignee_id;
        this.task_state = task_state;
    }

    public String getTask_id() {
        return task_id;
    }

    public String getAssignee_id() {
        return assignee_id;
    }

    public State getTask_state() {
        return task_state;
    }

    @Override
    public String toString() {
        return "task id: " + getTask_id()
                + ", assignee id" + getAssignee_id()
                + ", task state" + getTask_state();
    }
}
