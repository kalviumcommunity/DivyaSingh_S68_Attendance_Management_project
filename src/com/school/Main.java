package com.school;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Kalvium — Attendance Management Project (Part 1)");
        System.out.println("Setting up a simple Student class to demonstrate encapsulation.\n");

        Student s1 = new Student("S001", "Alice Johnson", 20, 82.5);
        Student s2 = new Student("S002", "Bob Kumar", 19, 68.0);

        System.out.println("Student Records:");
        System.out.println(s1);
        System.out.println(s2);

        // Demonstrate mutators and validation
        try {
            s2.setAttendancePercent(76.3);
            System.out.println("\nAfter updating Bob's attendance:");
            System.out.println(s2);
        } catch (IllegalArgumentException e) {
            System.err.println("Invalid data: " + e.getMessage());
        }

        // simple interaction example (optional)
        System.out.println("\nDone. Please follow the Git steps to push this to GitHub (see README).");
    }
}
