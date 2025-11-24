# Smart Task Manager – Full Edition
*A Modular Java Task Management System with JSON Storage*

## Overview
Smart Task Manager is a Java-based console application designed to manage users, tasks, and reports efficiently. It supports user creation, task assignment, status tracking, and report generation. The application uses JSON files for persistent storage and is structured using modular OOP principles.

##  Features
### ✔ User Management
- Add, view, and delete users
- Persistent storage in `users.json`

### ✔ Task Management
- Create tasks
- Assign tasks to users
- Update task status (Pending / In-progress / Completed)
- Delete tasks
- Stored in `tasks.json`

### ✔ Report Generation
- Tasks by user
- Status-based reports
- Overall summary of tasks

### ✔ Persistent Storage
- Uses **Gson** for JSON serialization  
- Data saved automatically

### ✔ Fat JAR Executable
- Packaged using Maven Assembly Plugin  
- Runs with all dependencies included

##  Project Structure
```
SmartTaskManager_Full/
├── src/main/java/com/vityarthi/smarttask/
│   ├── MainApp.java
│   ├── modules/
│   │   ├── UserModule.java
│   │   ├── TaskModule.java
│   │   └── ReportModule.java
│   ├── models/
│   │   ├── User.java
│   │   └── Task.java
│   └── utils/
│       └── JsonStorage.java
├── storage/
│   ├── users.json
│   └── tasks.json
├── pom.xml
└── README.md
```

##  Technologies Used
| Component | Details |
|----------|---------|
| Language | Java 17 |
| Build Tool | Maven |
| Storage | JSON files |
| Library | Gson 2.10.1 |
| Testing | JUnit 5 |
| Packaging | Fat JAR |

##  How to Build the Project
### 1. Install Requirements
```bash
java -version
mvn -version
```

### 2. Build
```bash
mvn clean package
```

##  Run the Application
```bash
java -jar target/SmartTaskManager-1.0-SNAPSHOT-jar-with-dependencies.jar
```

##  Testing
```bash
mvn test
```

##  Storage Files
- storage/users.json  
- storage/tasks.json

## Technical Details
- Modular architecture (UserModule, TaskModule, ReportModule)
- JSON serialization via Gson
- File handling, OOP, Collections, Exception Handling

## 🏁 Conclusion
A complete Java console project demonstrating clean architecture, modular design, and persistent storage.
