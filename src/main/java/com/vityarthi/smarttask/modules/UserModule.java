package com.vityarthi.smarttask.modules;

import com.google.gson.reflect.TypeToken;
import com.vityarthi.smarttask.MainApp;
import com.vityarthi.smarttask.models.User;
import com.vityarthi.smarttask.utils.JsonStorage;

import java.util.List;
import java.util.Scanner;

public class UserModule {
    private static final String FILE = "storage/users.json";

    private final List<User> users;
    private final Scanner sc;

    public UserModule(Scanner sc) {
        this.sc = sc;
        this.users = JsonStorage.load(FILE, new TypeToken<List<User>>() {}.getType());
    }

    public List<User> getUsers() {
        return users;
    }

    public void addUser() {
        System.out.print("Enter user name: ");
        String name = sc.nextLine().trim();
        if (name.isEmpty()) {
            System.out.println("Name cannot be empty.");
            return;
        }
        int id = 1;
        for (User u : users) {
            if (u.getId() >= id) id = u.getId() + 1;
        }
        users.add(new User(id, name));
        JsonStorage.save(FILE, users);
        System.out.println("User added with ID " + id);
    }

    public void viewUsers() {
        if (users.isEmpty()) {
            System.out.println("No users found.");
            return;
        }
        for (User u : users) {
            System.out.println(u);
        }
    }

    public void deleteUser() {
        int id = MainApp.readInt(sc, "Enter user ID to delete: ");
        boolean removed = users.removeIf(u -> u.getId() == id);
        if (removed) {
            JsonStorage.save(FILE, users);
            System.out.println("User deleted.");
        } else {
            System.out.println("User not found.");
        }
    }
}
