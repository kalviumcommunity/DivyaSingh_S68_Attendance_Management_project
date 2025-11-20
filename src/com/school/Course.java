package com.school;

/**
 * Course model implements Storable
 */
public class Course implements Storable {
    private static int nextCourseIdCounter = 101;

    private final int courseId;
    private String courseName;
    private String instructor;
    private int maxStudents;

    public Course(String courseName) {
        this.courseId = nextCourseIdCounter++;
        setCourseName(courseName);
        this.instructor = "TBD";
        this.maxStudents = 1;
    }

    public Course(String courseName, String instructor, int maxStudents) {
        this.courseId = nextCourseIdCounter++;
        setCourseName(courseName);
        setInstructor(instructor);
        setMaxStudents(maxStudents);
    }

    public int getCourseId() { return courseId; }
    public String getCourseName() { return courseName; }
    public String getInstructor() { return instructor; }
    public int getMaxStudents() { return maxStudents; }

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
        return String.format("Course{code='C%d', name='%s', instructor='%s', maxStudents=%d}",
                courseId, courseName, instructor, maxStudents);
    }

    // Storable implementation
    @Override
    public String toDataString() {
        // courseId,courseName
        return String.format("%d,%s", getCourseId(), getCourseName());
    }
}
