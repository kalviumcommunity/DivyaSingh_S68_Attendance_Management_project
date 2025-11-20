package com.school;

/**
 * Course model with constructor initialization and auto ID generation.
 */
public class Course {
    private static int nextCourseIdCounter = 101; // auto-increment starting at 101

    private final int courseId; // numeric id
    private String courseName;
    private String instructor;
    private int maxStudents;

    // Constructor - initializes id automatically and name from parameter
    public Course(String courseName) {
        this.courseId = nextCourseIdCounter++;
        setCourseName(courseName);
        this.instructor = "TBD";
        this.maxStudents = 1;
    }

    // Optional constructor with more details
    public Course(String courseName, String instructor, int maxStudents) {
        this.courseId = nextCourseIdCounter++;
        setCourseName(courseName);
        setInstructor(instructor);
        setMaxStudents(maxStudents);
    }

    // Getters
    public int getCourseId() { return courseId; }
    public String getCourseName() { return courseName; }
    public String getInstructor() { return instructor; }
    public int getMaxStudents() { return maxStudents; }

    // Setters with validation
    public void setCourseName(String courseName) {
        if (courseName == null || courseName.trim().isEmpty()) throw new IllegalArgumentException("Course name cannot be empty");
        this.courseName = courseName.trim();
    }

    public void setInstructor(String instructor) {
        if (instructor == null || instructor.trim().isEmpty()) this.instructor = "TBD";
        else this.instructor = instructor.trim();
    }

    public void setMaxStudents(int maxStudents) {
        if (maxStudents < 1) throw new IllegalArgumentException("maxStudents must be >= 1");
        this.maxStudents = maxStudents;
    }

    @Override
    public String toString() {
        // Display courseId prefixed with "C" as requested (e.g., C101)
        return String.format("Course{code='C%d', name='%s', instructor='%s', maxStudents=%d}",
                courseId, courseName, instructor, maxStudents);
    }
}
