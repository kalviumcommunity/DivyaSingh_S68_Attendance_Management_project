package com.school;

public class Main {

    public static void main(String[] args) {

        FileStorageService storage = new FileStorageService();

        // Initialize RegistrationService
        RegistrationService regService = new RegistrationService(storage);

        // Register Students
        Student s1 = new Student("Alice Johnson", "Grade 12", 20, 82.5);
        Student s2 = new Student("Bob Kumar", "Grade 11", 19, 68.0);
        regService.registerStudent(s1);
        regService.registerStudent(s2);

        // Register Teachers
        Teacher t1 = new Teacher("Dr. Mehta", "Programming");
        regService.registerTeacher(t1);

        // Register Staff
        Staff st1 = new Staff("Ramesh", "Lab Assistant");
        regService.registerStaff(st1);

        // Create Courses
        Course c1 = new Course("Introduction to Programming", "Dr. Mehta", 50);
        regService.createCourse(c1);

        // Initialize AttendanceService with RegistrationService
        AttendanceService attendanceService = new AttendanceService(storage, regService);

        // Mark Attendance using IDs
        attendanceService.markAttendance(s1.getId(), c1.getCourseId(), "Present");
        attendanceService.markAttendance(s2.getId(), c1.getCourseId(), "Absent");

        // Display School Directory
        displaySchoolDirectory(regService);

        // Display Attendance Logs
        attendanceService.displayAttendanceLog();

        // Save all data
        regService.saveAllRegistrations();
        attendanceService.saveAttendanceData();

        System.out.println("\nPart-09 complete. All files updated.");
    }

    public static void displaySchoolDirectory(RegistrationService regService) {
        System.out.println("\n--- School Directory ---");
        for (Person p : regService.getAllPeople()) {
            p.displayDetails();
        }
    }
}
