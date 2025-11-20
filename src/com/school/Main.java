package com.school;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Kalvium — Attendance Management (Part 04) : Data Encapsulation & Attendance Validation\n");

        // Students
        Student s1 = new Student("Alice Johnson", 20, 82.5);
        Student s2 = new Student("Bob Kumar", 19, 68.0);
        Student s3 = new Student("Clara Zhang", 21, 91.0);

        // Courses
        Course c1 = new Course("Introduction to Programming", "Dr. Mehta", 50);
        Course c2 = new Course("Data Structures", "Prof. Rao", 40);

        System.out.println("Students:");
        System.out.println("  " + s1);
        System.out.println("  " + s2);
        System.out.println("  " + s3);

        System.out.println("\nCourses:");
        System.out.println("  " + c1);
        System.out.println("  " + c2);

        // Attendance log using encapsulated getters to fetch ids
        List<AttendanceRecord> attendanceLog = new ArrayList<>();

        // valid records
        attendanceLog.add(new AttendanceRecord(s1.getStudentId(), c1.getCourseId(), "Present"));
        attendanceLog.add(new AttendanceRecord(s2.getStudentId(), c1.getCourseId(), "Absent"));
        attendanceLog.add(new AttendanceRecord(s3.getStudentId(), c2.getCourseId(), "present")); // case-insensitive

        // invalid record (should trigger warning & be marked "Invalid")
        attendanceLog.add(new AttendanceRecord(s1.getStudentId(), c2.getCourseId(), "Late")); // invalid status

        System.out.println("\nAttendance Log:");
        for (AttendanceRecord r : attendanceLog) {
            r.displayRecord();
        }

        System.out.println("\nPart-04 complete. Validation warnings (if any) printed above to stderr.");
    }
}
