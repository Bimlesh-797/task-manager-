package com.vityarthi.smarttask;

import com.vityarthi.smarttask.modules.ReportModule;
import com.vityarthi.smarttask.modules.TaskModule;
import com.vityarthi.smarttask.modules.UserModule;

import java.util.Scanner;

public class MainApp {

    // Reads a whole number from the keyboard (returns -1 if input is not a number)
    public static int readInt(Scanner sc, String prompt) {
        System.out.print(prompt);
        try {
            return Integer.parseInt(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        UserModule userModule = new UserModule(sc);
        TaskModule taskModule = new TaskModule(sc, userModule.getUsers());
        ReportModule reportModule = new ReportModule(userModule.getUsers(), taskModule.getTasks());

        while (true) {
            System.out.println();
            System.out.println("===== Smart Task Manager =====");
            System.out.println("1. Add user");
            System.out.println("2. View users");
            System.out.println("3. Delete user");
            System.out.println("4. Create task");
            System.out.println("5. View tasks");
            System.out.println("6. Assign task to user");
            System.out.println("7. Update task status");
            System.out.println("8. Delete task");
            System.out.println("9. Report: tasks by user");
            System.out.println("10. Report: tasks by status");
            System.out.println("11. Report: summary");
            System.out.println("0. Exit");
            int choice = readInt(sc, "Choose an option: ");
            System.out.println();

            switch (choice) {
                case 1: userModule.addUser(); break;
                case 2: userModule.viewUsers(); break;
                case 3: userModule.deleteUser(); break;
                case 4: taskModule.createTask(); break;
                case 5: taskModule.viewTasks(); break;
                case 6: taskModule.assignTask(); break;
                case 7: taskModule.updateStatus(); break;
                case 8: taskModule.deleteTask(); break;
                case 9: reportModule.tasksByUser(); break;
                case 10: reportModule.tasksByStatus(); break;
                case 11: reportModule.summary(); break;
                case 0:
                    System.out.println("Goodbye!");
                    return;
                default: System.out.println("Invalid option.");
            }
        }
    }
}
