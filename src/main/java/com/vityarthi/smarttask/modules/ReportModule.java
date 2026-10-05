package com.vityarthi.smarttask.modules;

import com.vityarthi.smarttask.models.Task;
import com.vityarthi.smarttask.models.User;

import java.util.List;

public class ReportModule {
    private final List<User> users;
    private final List<Task> tasks;

    public ReportModule(List<User> users, List<Task> tasks) {
        this.users = users;
        this.tasks = tasks;
    }

    public void tasksByUser() {
        for (User u : users) {
            System.out.println(u.getName() + ":");
            boolean any = false;
            for (Task t : tasks) {
                if (t.getUserId() == u.getId()) {
                    System.out.println("   " + t.getId() + " - " + t.getTitle() + " [" + t.getStatus() + "]");
                    any = true;
                }
            }
            if (!any) System.out.println("   (no tasks)");
        }
    }

    public void tasksByStatus() {
        String[] statuses = {"Pending", "In-progress", "Completed"};
        for (String s : statuses) {
            System.out.println(s + ":");
            boolean any = false;
            for (Task t : tasks) {
                if (t.getStatus().equals(s)) {
                    System.out.println("   " + t.getId() + " - " + t.getTitle());
                    any = true;
                }
            }
            if (!any) System.out.println("   (none)");
        }
    }

    public void summary() {
        int pending = 0, inProgress = 0, completed = 0;
        for (Task t : tasks) {
            if (t.getStatus().equals("Pending")) pending++;
            else if (t.getStatus().equals("In-progress")) inProgress++;
            else if (t.getStatus().equals("Completed")) completed++;
        }
        System.out.println("Total users     : " + users.size());
        System.out.println("Total tasks     : " + tasks.size());
        System.out.println("Pending         : " + pending);
        System.out.println("In-progress     : " + inProgress);
        System.out.println("Completed       : " + completed);
    }
}
