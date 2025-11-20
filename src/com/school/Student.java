package com.school;

/**
 * Student class demonstrating encapsulation (private fields + getters/setters)
 */
public class Student {
    private String id;
    private String name;
    private int age;
    private double attendancePercent;

    // Constructor
    public Student(String id, String name, int age, double attendancePercent) {
        this.id = id;
        this.name = name;
        this.age = age;
        setAttendancePercent(attendancePercent); // use setter for validation
    }

    // Getters (read-only accessors)
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getAttendancePercent() {
        return attendancePercent;
    }

    // Setters (mutators) with simple validation
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) throw new IllegalArgumentException("Name cannot be empty");
        this.name = name.trim();
    }

    public void setAge(int age) {
        if (age < 3 || age > 120) throw new IllegalArgumentException("Age seems invalid");
        this.age = age;
    }

    public void setAttendancePercent(double attendancePercent) {
        if (attendancePercent < 0.0) attendancePercent = 0.0;
        if (attendancePercent > 100.0) attendancePercent = 100.0;
        this.attendancePercent = attendancePercent;
    }

    // Business method
    public boolean isEligibleForCertificate() {
        // e.g., eligible if attendance >= 75%
        return this.attendancePercent >= 75.0;
    }

    @Override
    public String toString() {
        return String.format("Student{id='%s', name='%s', age=%d, attendance=%.2f%%, eligible=%s}",
                id, name, age, attendancePercent, isEligibleForCertificate() ? "YES" : "NO");
    }
}
