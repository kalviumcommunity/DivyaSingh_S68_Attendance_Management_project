package com.school;

import java.util.ArrayList;
import java.util.List;

public class AttendanceService {

    private final List<AttendanceRecord> attendanceLog;
    private final FileStorageService storage;
    private final RegistrationService registrationService;

    public AttendanceService(FileStorageService storage, RegistrationService registrationService) {
        this.attendanceLog = new ArrayList<>();
        this.storage = storage;
        this.registrationService = registrationService;
    }

    // Mark attendance using objects
    public void markAttendance(Student student, Course course, String status) {
        AttendanceRecord record = new AttendanceRecord(student, course, status);
        attendanceLog.add(record);
    }

    // Mark attendance using IDs, use registrationService for lookups
    public void markAttendance(int studentId, int courseId, String status) {
        Student student = registrationService.findStudentById(studentId);
        Course course = registrationService.findCourseById(courseId);
        if (student != null && course != null) {
            markAttendance(student, course, status);
        } else {
            System.err.println("[WARNING] Invalid student or course ID.");
        }
    }

    // Display attendance
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

    // Save attendance
    public void saveAttendanceData() {
        storage.saveData(attendanceLog, "attendance_log.txt");
    }
}
