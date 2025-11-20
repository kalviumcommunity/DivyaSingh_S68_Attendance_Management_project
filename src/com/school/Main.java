package com.school;

public class Main {
    public static void main(String[] args) {
        System.out.println("Kalvium — Attendance Management (Part 03) : Constructor Initialization & Auto-ID\n");

        // Create students using new constructor (auto-id)
        Student s1 = new Student("Alice Johnson", 20, 82.5);
        Student s2 = new Student("Bob Kumar", 19, 68.0);
        Student s3 = new Student("Clara Zhang");
        Student s4 = new Student("Daniel Lee", 22, 74.9);
        Student s5 = new Student("Esha Patel", 18, 95.0);

        Student[] students = new Student[] { s1, s2, s3, s4, s5 };

        // Create courses using new constructor (auto-id starting 101)
        Course c1 = new Course("Introduction to Programming", "Dr. Mehta", 50);
        Course c2 = new Course("Data Structures", "Prof. Rao", 40);
        Course c3 = new Course("Algorithms"); // instructor = TBD

        Course[] courses = new Course[] { c1, c2, c3 };

        // Display students to show auto-generated IDs
        System.out.println("Students:");
        for (Student s : students) {
            System.out.println("  " + s);
        }

        // Display courses to show auto-generated course IDs prefixed with C
        System.out.println("\nCourses:");
        for (Course c : courses) {
            System.out.println("  " + c);
        }

        // Small demonstration: create one more student and course to show counters increment
        Student extraStudent = new Student("Farah Khan");
        Course extraCourse = new Course("Database Systems", "Dr. Singh", 45);

        System.out.println("\nAfter creating additional instances:");
        System.out.println("  " + extraStudent);
        System.out.println("  " + extraCourse);

        System.out.println("\nPart-03 complete. Verify auto ID generation above (students S1.., courses C101..).");
    }
}
