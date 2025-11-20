package com.school;

public class AttendanceRecord implements Storable {
    private final Student student;
    private final Course course;
    private final String status; // "Present", "Absent", or "Invalid"

    public AttendanceRecord(Student student, Course course, String status) {
        this.student = student;
        this.course = course;

        if (status == null) {
            this.status = "Invalid";
            System.err.println("[WARNING] AttendanceRecord: status is null -> set to 'Invalid' (studentId=" + student.getId() + ", courseId=C" + course.getCourseId() + ")");
        } else {
            String normalized = status.trim().toLowerCase();
            if (normalized.equals("present")) this.status = "Present";
            else if (normalized.equals("absent")) this.status = "Absent";
            else {
                this.status = "Invalid";
                System.err.println("[WARNING] AttendanceRecord: invalid status '" + status + "' -> set to 'Invalid' (studentId=" + student.getId() + ", courseId=C" + course.getCourseId() + ")");
            }
        }
    }

    public Student getStudent() { return student; }
    public Course getCourse() { return course; }
    public String getStatus() { return status; }

    public void displayRecord() {
        System.out.printf("AttendanceRecord -> Student: S%d (%s), Course: C%d (%s), Status: %s%n",
                student.getId(), student.getName(),
                course.getCourseId(), course.getCourseName(),
                status);
    }

    @Override
    public String toDataString() {
        return String.format("%d,%d,%s", student.getId(), course.getCourseId(), status);
    }
}
