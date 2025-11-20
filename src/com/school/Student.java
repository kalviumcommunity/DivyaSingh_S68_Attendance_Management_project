package com.school;

/**
 * Student extends Person. Student has grade level, age and attendance percent.
 */
public class Student extends Person {
    private String gradeLevel;
    private int age;
    private double attendancePercent;

    // Constructor with only name and grade
    public Student(String name, String gradeLevel) {
        super(name);
        setGradeLevel(gradeLevel);
        this.age = 0;
        this.attendancePercent = 0.0;
    }

    // Constructor with name, grade, age and attendance
    public Student(String name, String gradeLevel, int age, double attendancePercent) {
        super(name);
        setGradeLevel(gradeLevel);
        setAge(age);
        setAttendancePercent(attendancePercent);
    }

    public String getGradeLevel() { return gradeLevel; }
    public void setGradeLevel(String gradeLevel) {
        if (gradeLevel == null || gradeLevel.trim().isEmpty()) gradeLevel = "N/A";
        this.gradeLevel = gradeLevel.trim();
    }

    public int getAge() { return age; }
    public void setAge(int age) {
        if (age < 3 || age > 120) throw new IllegalArgumentException("Invalid age");
        this.age = age;
    }

    public double getAttendancePercent() { return attendancePercent; }
    public void setAttendancePercent(double attendancePercent) {
        if (attendancePercent < 0.0) attendancePercent = 0.0;
        if (attendancePercent > 100.0) attendancePercent = 100.0;
        this.attendancePercent = attendancePercent;
    }

    // override displayDetails
    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.printf("  Role: Student, Grade: %s, Age: %d, Attendance: %.2f%%%n", gradeLevel, age, attendancePercent);
    }

    // keep a compact toString if useful
    @Override
    public String toString() {
        return String.format("Student{S%d, name='%s', grade='%s', age=%d, attendance=%.2f%%}",
                id, name, gradeLevel, age, attendancePercent);
    }
}
