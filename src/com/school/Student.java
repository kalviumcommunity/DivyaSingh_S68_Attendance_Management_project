package com.school;

/**
 * Student model with encapsulation and auto ID generation.
 */
public class Student {
    private static int nextStudentIdCounter = 1;

    private final int studentId;
    private String name;
    private int age;
    private double attendancePercent;

    public Student(String name) {
        this.studentId = nextStudentIdCounter++;
        setName(name);
        this.age = 0;
        this.attendancePercent = 0.0;
    }

    public Student(String name, int age, double attendancePercent) {
        this.studentId = nextStudentIdCounter++;
        setName(name);
        setAge(age);
        setAttendancePercent(attendancePercent);
    }

    // Public getters (encapsulation)
    public int getStudentId() { return studentId; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public double getAttendancePercent() { return attendancePercent; }

    // Setters with validation
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) throw new IllegalArgumentException("Name cannot be empty");
        this.name = name.trim();
    }
    public void setAge(int age) {
        if (age < 3 || age > 120) throw new IllegalArgumentException("Invalid age");
        this.age = age;
    }
    public void setAttendancePercent(double attendancePercent) {
        if (attendancePercent < 0.0) attendancePercent = 0.0;
        if (attendancePercent > 100.0) attendancePercent = 100.0;
        this.attendancePercent = attendancePercent;
    }

    public boolean isEligibleForCertificate() {
        return this.attendancePercent >= 75.0;
    }

    @Override
    public String toString() {
        return String.format("Student{id='S%d', name='%s', age=%d, attendance=%.2f%%, eligible=%s}",
                studentId, name, age, attendancePercent, isEligibleForCertificate() ? "YES" : "NO");
    }
}
