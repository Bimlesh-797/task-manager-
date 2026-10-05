package com.vityarthi.smarttask.modules;

import com.google.gson.reflect.TypeToken;
import com.vityarthi.smarttask.MainApp;
import com.vityarthi.smarttask.models.Task;
import com.vityarthi.smarttask.models.User;
import com.vityarthi.smarttask.utils.JsonStorage;

import java.util.List;
import java.util.Scanner;

public class TaskModule {
    private static final String FILE = "storage/tasks.json";

    private final List<Task> tasks;
    private final List<User> users;
    private final Scanner sc;

    public TaskModule(Scanner sc, List<User> users) {
        this.sc = sc;
        this.users = users;
        this.tasks = JsonStorage.load(FILE, new TypeToken<List<Task>>() {}.getType());
    }

    public List<Task> getTasks() {
        return tasks;
    }

    private Task findTask(int id) {
        for (Task t : tasks) {
            if (t.getId() == id) return t;
        }
        return null;
    }

    private String userName(int userId) {
        for (User u : users) {
            if (u.getId() == userId) return u.getName();
        }
        return "Unassigned";
    }

    public void createTask() {
        System.out.print("Enter task title: ");
        String title = sc.nextLine().trim();
        if (title.isEmpty()) {
            System.out.println("Title cannot be empty.");
            return;
        }
        int id = 1;
        for (Task t : tasks) {
            if (t.getId() >= id) id = t.getId() + 1;
        }
        tasks.add(new Task(id, title));
        JsonStorage.save(FILE, tasks);
        System.out.println("Task created with ID " + id);
    }

    public void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks found.");
            return;
        }
        for (Task t : tasks) {
            System.out.println(t.getId() + " - " + t.getTitle()
                    + " | " + t.getStatus()
                    + " | " + userName(t.getUserId()));
        }
    }

    public void assignTask() {
        Task task = findTask(MainApp.readInt(sc, "Enter task ID: "));
        if (task == null) {
            System.out.println("Task not found.");
            return;
        }
        int userId = MainApp.readInt(sc, "Enter user ID to assign: ");
        boolean exists = false;
        for (User u : users) {
            if (u.getId() == userId) exists = true;
        }
        if (!exists) {
            System.out.println("User not found.");
            return;
        }
        task.setUserId(userId);
        JsonStorage.save(FILE, tasks);
        System.out.println("Task assigned.");
    }

    public void updateStatus() {
        Task task = findTask(MainApp.readInt(sc, "Enter task ID: "));
        if (task == null) {
            System.out.println("Task not found.");
            return;
        }
        System.out.println("1. Pending");
        System.out.println("2. In-progress");
        System.out.println("3. Completed");
        int choice = MainApp.readInt(sc, "Choose new status: ");
        if (choice == 1) task.setStatus("Pending");
        else if (choice == 2) task.setStatus("In-progress");
        else if (choice == 3) task.setStatus("Completed");
        else {
            System.out.println("Invalid choice.");
            return;
        }
        JsonStorage.save(FILE, tasks);
        System.out.println("Status updated.");
    }

    public void deleteTask() {
        int id = MainApp.readInt(sc, "Enter task ID to delete: ");
        boolean removed = tasks.removeIf(t -> t.getId() == id);
        if (removed) {
            JsonStorage.save(FILE, tasks);
            System.out.println("Task deleted.");
        } else {
            System.out.println("Task not found.");
        }
    }
}
