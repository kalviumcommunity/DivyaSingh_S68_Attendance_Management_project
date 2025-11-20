package com.school;

import java.util.List;

public class Main {
    public static void displaySchoolDirectory(RegistrationService regService) {
        List<Person> people = regService.getAllPeople();
        for (Person p : people) {
            p.displayDetails();
            System.out.println("----------------");
        }
    }

    public static void main(String[] args) {
        FileStorageService storageService = new FileStorageService();
        RegistrationService regService = new RegistrationService(storageService);
        AttendanceService attendanceService = new AttendanceService(storageService, regService);

        // Register Students
        Student s1 = regService.registerStudent("Alice", "10th");
        Student s2 = regService.registerStudent("Bob", "10th");
        Student s3 = regService.registerStudent("Charlie", "11th");

        // Register Teachers
        Teacher t1 = regService.registerTeacher("Mr. Smith", "Math");
        Teacher t2 = regService.registerTeacher("Ms. Johnson", "Science");

        // Register Staff
        Staff st1 = regService.registerStaff("Mark", "Lab Assistant");
        Staff st2 = regService.registerStaff("Anna", "Receptionist");

        // Create Courses
        Course c1 = regService.createCourse("Math", 2); // capacity 2
        Course c2 = regService.createCourse("Science", 3);

        // Enroll Students
        regService.enrollStudentInCourse(s1, c1);
        regService.enrollStudentInCourse(s2, c1);
        regService.enrollStudentInCourse(s3, c1); // exceeds capacity
        regService.enrollStudentInCourse(s3, c2);

        // Display Courses
        c1.displayDetails();
        c2.displayDetails();

        // Mark Attendance
        attendanceService.markAttendance(s1, c1, "Present");
        attendanceService.markAttendance(s2, c1, "Absent");
        attendanceService.markAttendance(s3, c2, "Present");

        // Display Attendance Logs
        System.out.println("Full Attendance Log:");
        attendanceService.displayAttendanceLog();

        // Display School Directory
        System.out.println("\nSchool Directory:");
        displaySchoolDirectory(regService);

        // Save data to files
        regService.saveAllRegistrations();
        attendanceService.saveAttendanceData();
    }
}
