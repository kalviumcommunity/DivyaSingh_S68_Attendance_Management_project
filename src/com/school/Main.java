package com.school;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Kalvium — Attendance Management (Part 05) : Inheritance Hierarchy\n");

        // Create people
        Student st1 = new Student("Alice Johnson", "Grade 12", 20, 82.5);
        Student st2 = new Student("Bob Kumar", "Grade 11", 19, 68.0);

        Teacher t1 = new Teacher("Dr. Mehta", "Computer Science");
        Teacher t2 = new Teacher("Prof. Rao", "Mathematics");

        Staff sf1 = new Staff("Mr. Sharma", "Lab Assistant");
        Staff sf2 = new Staff("Ms. Nair", "Librarian");

        // Display details (polymorphic behavior: each class prints its role-specific info)
        System.out.println("=== People Details ===");
        st1.displayDetails();
        st2.displayDetails();
        t1.displayDetails();
        t2.displayDetails();
        sf1.displayDetails();
        sf2.displayDetails();

        // Example courses (reuse Course from earlier parts)
        Course c1 = new Course("Introduction to Programming", "Dr. Mehta", 50);
        Course c2 = new Course("Data Structures", "Prof. Rao", 40);

        // Use student.getId() in attendance records
        List<AttendanceRecord> attendanceLog = new ArrayList<>();
        attendanceLog.add(new AttendanceRecord(st1.getId(), c1.getCourseId(), "Present"));
        attendanceLog.add(new AttendanceRecord(st2.getId(), c1.getCourseId(), "Absent"));

        System.out.println("\n=== Attendance Log ===");
        for (AttendanceRecord r : attendanceLog) r.displayRecord();

        System.out.println("\nPart-05 complete. Person hierarchy implemented (Person -> Student/Teacher/Staff).");
    }
}
