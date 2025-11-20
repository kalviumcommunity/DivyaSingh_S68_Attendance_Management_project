package com.school;

/**
 * Course model for Part-02
 */
public class Course {
    private String code;
    private String title;
    private String instructor;
    private int maxStudents;

    public Course(String code, String title, String instructor, int maxStudents) {
        this.code = code;
        this.title = title;
        this.instructor = instructor;
        this.maxStudents = Math.max(1, maxStudents);
    }

    // getters and setters
    public String getCode() { return code; }
    public String getTitle() { return title; }
    public String getInstructor() { return instructor; }
    public int getMaxStudents() { return maxStudents; }

    public void setTitle(String title) {
        if (title == null || title.trim().isEmpty()) throw new IllegalArgumentException("Title cannot be empty");
        this.title = title.trim();
    }

    public void setInstructor(String instructor) {
        if (instructor == null || instructor.trim().isEmpty()) throw new IllegalArgumentException("Instructor cannot be empty");
        this.instructor = instructor.trim();
    }

    public void setMaxStudents(int maxStudents) {
        if (maxStudents < 1) throw new IllegalArgumentException("maxStudents must be >= 1");
        this.maxStudents = maxStudents;
    }

    @Override
    public String toString() {
        return String.format("Course{code='%s', title='%s', instructor='%s', maxStudents=%d}",
                code, title, instructor, maxStudents);
    }
}
