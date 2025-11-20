package com.school;

/**
 * Teacher extends Person.
 */
public class Teacher extends Person {
    private String subjectTaught;

    public Teacher(String name, String subjectTaught) {
        super(name);
        setSubjectTaught(subjectTaught);
    }

    public String getSubjectTaught() { return subjectTaught; }
    public void setSubjectTaught(String subjectTaught) {
        if (subjectTaught == null || subjectTaught.trim().isEmpty()) subjectTaught = "General";
        this.subjectTaught = subjectTaught.trim();
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.printf("  Role: Teacher, Subject: %s%n", subjectTaught);
    }

    @Override
    public String toString() {
        return String.format("Teacher{T%d, name='%s', subject='%s'}", id, name, subjectTaught);
    }
}
