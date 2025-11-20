package com.school;

import java.util.ArrayList;
import java.util.List;

public class Main {

    // Polymorphic method: display details of all people
    public static void displaySchoolDirectory(List<Person> people) {
        System.out.println("\n--- School Directory (Polymorphic display) ---");
        for (Person person : people) {
            person.displayDetails();
        }
    }

    public static void main(String[] args) {
        System.out.println("Kalvium — Attendance Management (Part 07) : Polymorphic Behaviour\n");

        // Create Students
        Student s1 = new Student("Alice Johnson", "Grade 12", 20, 82.5);
        Student s2 = new Student("Bob Kumar", "Grade 11", 19, 68.0);
        Student s3 = new Student("Clara Zhang", "Grade 12", 21, 91.0);

        // Create Teachers
        Teacher t1 = new Teacher("Dr. Mehta", "Mathematics");
        Teacher t2 = new Teacher("Prof. Rao", "Computer Science");

        // Create Staff
        Staff st1 = new Staff("Mr. Singh", "Librarian");
        Staff st2 = new Staff("Ms. Patel", "Lab Assistant");

        // Create school people list (polymorphic)
        List<Person> schoolPeople = new ArrayList<>();
        schoolPeople.add(s1); schoolPeople.add(s2); schoolPeople.add(s3);
        schoolPeople.add(t1); schoolPeople.add(t2);
        schoolPeople.add(st1); schoolPeople.add(st2);

        // Display directory (polymorphism demonstration)
        displaySchoolDirectory(schoolPeople);

        // Create Courses
        Course c1 = new Course("Introduction to Programming", "Dr. Mehta", 50);
        Course c2 = new Course("Data Structures", "Prof. Rao", 40);

        // Attendance records using actual Student & Course objects
        List<AttendanceRecord> records = new ArrayList<>();
        records.add(new AttendanceRecord(s1, c1, "Present"));
        records.add(new AttendanceRecord(s2, c1, "Absent"));
        records.add(new AttendanceRecord(s3, c2, "Present"));
        records.add(new AttendanceRecord(s1, c2, "Late")); // Invalid status test

        // Display attendance
        System.out.println("\n--- Attendance Log ---");
        for (AttendanceRecord r : records) r.displayRecord();

        // Save only students to file (filter from schoolPeople)
        List<Student> studentsForFile = new ArrayList<>();
        for (Person p : schoolPeople) {
            if (p instanceof Student) studentsForFile.add((Student) p);
        }

        FileStorageService storage = new FileStorageService();
        storage.saveData(studentsForFile, "students.txt");
        storage.saveData(List.of(c1, c2), "courses.txt");
        storage.saveData(records, "attendance_log.txt");

        System.out.println("\nPart-07 complete. Files updated: students.txt, courses.txt, attendance_log.txt");
    }
}
