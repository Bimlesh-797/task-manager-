package com.vityarthi.smarttask.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParseException;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class JsonStorage {
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    // Read a list from a JSON file (empty list if file is missing or empty)
    public static <T> List<T> load(String path, Type type) {
        try (Reader reader = new FileReader(path)) {
            List<T> list = gson.fromJson(reader, type);
            return list == null ? new ArrayList<>() : list;
        } catch (IOException | JsonParseException e) {
            return new ArrayList<>();
        }
    }

    // Write any object (our lists) to a JSON file
    public static void save(String path, Object data) {
        try {
            File parent = new File(path).getParentFile();
            if (parent != null) parent.mkdirs();
            try (Writer writer = new FileWriter(path)) {
                gson.toJson(data, writer);
            }
        } catch (IOException e) {
            System.out.println("Could not save " + path + ": " + e.getMessage());
        }
    }
}
