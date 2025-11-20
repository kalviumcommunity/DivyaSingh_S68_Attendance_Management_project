# DivyaSingh_S68_Attendance_Management_project

# YourName_SXX_Attendance_management_project

**Project:** Attendance Management Project — Part 1  
**Student:** Your Full Name  
**Squad:** SXX

## Description
Part 1: Project setup and a small Java app demonstrating encapsulation using a `Student` class and a `Main` program.

## How to compile & run
From project root:
```bash
javac src/com/school/Student.java src/com/school/Main.java
java -cp src com.school.Main


## Part-02 — Core Domain Modelling

This part introduces `Student` and `Course` domain classes and demonstrates managing them using arrays.

### How to compile & run
```bash
javac src/com/school/*.java
java -cp src com.school.Main


## Part-03 — Constructor Initialization & Auto-ID Generation

This part implements constructors for `Student` and `Course` and adds automatic unique ID generation using static counters.

### What changed
- `Student` now auto-generates integer IDs (studentId) using `nextStudentIdCounter` and constructors `Student(String name)` and `Student(String name, int age, double attendancePercent)`.
- `Course` now auto-generates integer IDs (courseId) starting at 101 using `nextCourseIdCounter` and constructors `Course(String courseName)` and `Course(String courseName, String instructor, int maxStudents)`.
- `Course` `toString()` prints the id prefixed with `C` (e.g., `C101`).

### How to compile & run
From project root:
```bash
javac src/com/school/*.java
java -cp src com.school.Main
