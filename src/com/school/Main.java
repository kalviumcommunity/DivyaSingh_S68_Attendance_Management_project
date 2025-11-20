package com.school;

public class Main {
    public static void main(String[] args) {
        System.out.println("Kalvium — Attendance Management (Part 02) : Core Domain Modelling\n");

        // Create students
        Student[] students = new Student[3];
        students[0] = new Student("S001", "Alice Johnson", 20, 82.5);
        students[1] = new Student("S002", "Bob Kumar", 19, 68.0);
        students[2] = new Student("S003", "Clara Zhang", 21, 91.0);

        // Create courses
        Course[] courses = new Course[2];
        courses[0] = new Course("C101", "Introduction to Programming", "Dr. Mehta", 50);
        courses[1] = new Course("C102", "Data Structures", "Prof. Rao", 40);

        // Display students
        System.out.println("Students enrolled:");
        for (Student s : students) {
            System.out.println("  " + s);
        }

        // Display courses
        System.out.println("\nAvailable courses:");
        for (Course c : courses) {
            System.out.println("  " + c);
        }

        // Example: simple mapping logic (student -> course index) using arrays
        int[][] enrollments = new int[students.length][]; // store enrolled course indices per student
        enrollments[0] = new int[]{0, 1}; // Alice enrolled in both courses
        enrollments[1] = new int[]{1};    // Bob enrolled in Data Structures
        enrollments[2] = new int[]{0};    // Clara enrolled in Intro

        System.out.println("\nEnrollments:");
        for (int i = 0; i < students.length; i++) {
            System.out.print("  " + students[i].getName() + " -> ");
            int[] list = enrollments[i];
            for (int j = 0; j < list.length; j++) {
                int courseIndex = list[j];
                System.out.print(courses[courseIndex].getCode());
                if (j < list.length - 1) System.out.print(", ");
            }
            System.out.println();
        }

        System.out.println("\nPart-02 complete. Follow git steps to push changes to part-02 branch.");
    }
}
