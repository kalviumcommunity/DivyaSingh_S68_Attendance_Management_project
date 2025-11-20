package com.school;

/**
 * AttendanceRecord stores a student's attendance status for a course.
 * Valid statuses (case-insensitive): "Present", "Absent"
 * Any other value will be stored as "Invalid" and a warning will be printed.
 */
public class AttendanceRecord {
    private final int studentId;
    private final int courseId;
    private final String status; // "Present", "Absent", or "Invalid"

    public AttendanceRecord(int studentId, int courseId, String status) {
        this.studentId = studentId;
        this.courseId = courseId;

        if (status == null) {
            this.status = "Invalid";
            System.err.println("[WARNING] AttendanceRecord: status is null -> set to 'Invalid' (studentId=" + studentId + ", courseId=C" + courseId + ")");
        } else {
            String normalized = status.trim().toLowerCase();
            if (normalized.equals("present")) {
                this.status = "Present";
            } else if (normalized.equals("absent")) {
                this.status = "Absent";
            } else {
                this.status = "Invalid";
                System.err.println("[WARNING] AttendanceRecord: invalid status '" + status + "' -> set to 'Invalid' (studentId=" + studentId + ", courseId=C" + courseId + ")");
            }
        }
    }

    // Getters
    public int getStudentId() { return studentId; }
    public int getCourseId() { return courseId; }
    public String getStatus() { return status; }

    // Display the record in a readable format
    public void displayRecord() {
        System.out.printf("AttendanceRecord -> Student: S%d, Course: C%d, Status: %s%n", studentId, courseId, status);
    }
}
