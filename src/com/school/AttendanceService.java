package com.school;

import java.util.ArrayList;
import java.util.List;

public class AttendanceService {

    private final List<AttendanceRecord> attendanceLog;
    private final FileStorageService storageService;

    // Constructor
    public AttendanceService(FileStorageService storageService) {
        this.attendanceLog = new ArrayList<>();
        this.storageService = storageService;
    }

    // Overloaded markAttendance using actual objects
    public void markAttendance(Student student, Course course, String status) {
        AttendanceRecord record = new AttendanceRecord(student, course, status);
        attendanceLog.add(record);
    }

    // Overloaded markAttendance using IDs
    public void markAttendance(int studentId, int courseId, String status, List<Student> allStudents, List<Course> allCourses) {
        Student student = findStudentById(studentId, allStudents);
        Course course = findCourseById(courseId, allCourses);
        if (student != null && course != null) {
            markAttendance(student, course, status);
        } else {
            System.err.println("[WARNING] Unable to mark attendance: Invalid Student ID or Course ID.");
        }
    }

    // Helper methods to find Student or Course by ID
    private Student findStudentById(int id, List<Student> students) {
        for (Student s : students) {
            if (s.getId() == id) return s;
        }
        return null;
    }

    private Course findCourseById(int id, List<Course> courses) {
        for (Course c : courses) {
            if (c.getCourseId() == id) return c;
        }
        return null;
    }

    // Overloaded displayAttendanceLog methods
    public void displayAttendanceLog() {
        System.out.println("\n--- Full Attendance Log ---");
        for (AttendanceRecord r : attendanceLog) r.displayRecord();
    }

    public void displayAttendanceLog(Student student) {
        System.out.println("\n--- Attendance for Student: " + student.getName() + " ---");
        for (AttendanceRecord r : attendanceLog) {
            if (r.getStudent().getId() == student.getId()) r.displayRecord();
        }
    }

    public void displayAttendanceLog(Course course) {
        System.out.println("\n--- Attendance for Course: " + course.getCourseName() + " ---");
        for (AttendanceRecord r : attendanceLog) {
            if (r.getCourse().getCourseId() == course.getCourseId()) r.displayRecord();
        }
    }

    // Save attendance log to file
    public void saveAttendanceData() {
        storageService.saveData(attendanceLog, "attendance_log.txt");
    }
}
