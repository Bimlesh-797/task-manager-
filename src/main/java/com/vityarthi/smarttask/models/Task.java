package com.vityarthi.smarttask.models;

public class Task {
    private int id;
    private String title;
    private int userId;      // 0 means not assigned
    private String status;   // Pending / In-progress / Completed

    public Task(int id, String title) {
        this.id = id;
        this.title = title;
        this.userId = 0;
        this.status = "Pending";
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public int getUserId() { return userId; }
    public String getStatus() { return status; }

    public void setUserId(int userId) { this.userId = userId; }
    public void setStatus(String status) { this.status = status; }
}
