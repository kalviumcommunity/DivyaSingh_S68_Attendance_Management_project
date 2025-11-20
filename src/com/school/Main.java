package com.school;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("Kalvium — Attendance Management (Part 08) : Overloaded Commands\n");

        // File Storage Service
        FileStorageService storage = new FileStorageService();

        // Create Students
        List<Student> allStudents = new ArrayList<>();
        Student s1 = new Student("Alice Johnson", "Grade 12", 20, 82.5);
        Student s2 = new Student("Bob Kumar", "Grade 11", 19, 68.0);
        Student s3 = new Student("Clara Zhang", "Grade 12", 21, 91.0);
        allStudents.add(s1); allStudents.add(s2); allStudents.add(s3);

        // Create Courses
        List<Course> allCourses = new ArrayList<>();
        Course c1 = new Course("Introduction to Programming", "Dr. Mehta", 50);
        Course c2 = new Course("Data Structures", "Prof. Rao", 40);
        allCourses.add(c1); allCourses.add(c2);

        // AttendanceService
        AttendanceService attendanceService = new AttendanceService(storage);

        // Mark attendance (object version)
        attendanceService.markAttendance(s1, c1, "Present");
        attendanceService.markAttendance(s2, c1, "Absent");

        // Mark attendance (ID version)
        attendanceService.markAttendance(s3.getId(), c2.getCourseId(), "Present", allStudents, allCourses);
        attendanceService.markAttendance(s1.getId(), c2.getCourseId(), "Late", allStudents, allCourses); // Invalid

        // Display attendance logs
        attendanceService.displayAttendanceLog();            // All
        attendanceService.displayAttendanceLog(s1);          // By student
        attendanceService.displayAttendanceLog(c2);          // By course

        // Save to file
        attendanceService.saveAttendanceData();

        System.out.println("\nPart-08 complete. attendance_log.txt updated.");
    }
}
