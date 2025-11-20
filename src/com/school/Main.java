package com.school;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Kalvium — Attendance Management (Part 06) : Interface-Driven Persistence\n");

        // Students
        List<Student> students = new ArrayList<>();
        students.add(new Student("Alice Johnson", "Grade 12", 20, 82.5));
        students.add(new Student("Bob Kumar", "Grade 11", 19, 68.0));
        students.add(new Student("Clara Zhang", "Grade 12", 21, 91.0));

        // Courses
        List<Course> courses = new ArrayList<>();
        courses.add(new Course("Introduction to Programming", "Dr. Mehta", 50));
        courses.add(new Course("Data Structures", "Prof. Rao", 40));

        // Attendance records - use student.getId() and course.getCourseId()
        List<AttendanceRecord> records = new ArrayList<>();
        records.add(new AttendanceRecord(students.get(0).getId(), courses.get(0).getCourseId(), "Present"));
        records.add(new AttendanceRecord(students.get(1).getId(), courses.get(0).getCourseId(), "Absent"));
        records.add(new AttendanceRecord(students.get(2).getId(), courses.get(1).getCourseId(), "Present"));
        records.add(new AttendanceRecord(students.get(0).getId(), courses.get(1).getCourseId(), "Late")); // invalid -> should be marked Invalid

        // Print a preview to console
        System.out.println("Preview (console):");
        System.out.println("Students:");
        for (Student s : students) System.out.println("  " + s.toDataString());
        System.out.println("Courses:");
        for (Course c : courses) System.out.println("  " + c.toDataString());
        System.out.println("Attendance records:");
        for (AttendanceRecord r : records) System.out.println("  " + r.toDataString());

        // Save to files using FileStorageService
        FileStorageService storage = new FileStorageService();
        storage.saveData(students, "students.txt");
        storage.saveData(courses, "courses.txt");
        storage.saveData(records, "attendance_log.txt");

        System.out.println("\nPart-06 complete. Check students.txt, courses.txt, attendance_log.txt in the project root.");
    }
}
