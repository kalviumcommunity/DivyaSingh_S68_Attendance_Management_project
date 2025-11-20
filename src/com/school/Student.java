package com.school;

/**
 * Student extends Person and is storable.
 */
public class Student extends Person implements Storable {
    private String gradeLevel;
    private int age;
    private double attendancePercent;

    public Student(String name, String gradeLevel) {
        super(name);
        setGradeLevel(gradeLevel);
        this.age = 0;
        this.attendancePercent = 0.0;
    }

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

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.printf("  Role: Student, Grade: %s, Age: %d, Attendance: %.2f%%%n",
                gradeLevel, age, attendancePercent);
    }

    @Override
    public String toString() {
        return String.format("Student{S%d, name='%s', grade='%s', age=%d, attendance=%.2f%%}",
                id, name, gradeLevel, age, attendancePercent);
    }

    // Storable implementation
    @Override
    public String toDataString() {
        // id,name,gradeLevel
        return String.format("%d,%s,%s", getId(), getName(), getGradeLevel());
    }
}
