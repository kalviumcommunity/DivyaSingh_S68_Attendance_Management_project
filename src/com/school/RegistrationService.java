package com.school;

import java.util.ArrayList;
import java.util.List;

public class RegistrationService {

    private final List<Student> students;
    private final List<Teacher> teachers;
    private final List<Staff> staffMembers;
    private final List<Course> courses;
    private final FileStorageService storage;

    public RegistrationService(FileStorageService storage) {
        this.students = new ArrayList<>();
        this.teachers = new ArrayList<>();
        this.staffMembers = new ArrayList<>();
        this.courses = new ArrayList<>();
        this.storage = storage;
    }

    // Registration methods
    public void registerStudent(Student student) { students.add(student); }
    public void registerTeacher(Teacher teacher) { teachers.add(teacher); }
    public void registerStaff(Staff staff) { staffMembers.add(staff); }
    public void createCourse(Course course) { courses.add(course); }

    // Getters
    public List<Student> getStudents() { return students; }
    public List<Teacher> getTeachers() { return teachers; }
    public List<Staff> getStaffMembers() { return staffMembers; }
    public List<Course> getCourses() { return courses; }

    // Lookup by ID
    public Student findStudentById(int id) {
        return students.stream().filter(s -> s.getId() == id).findFirst().orElse(null);
    }

    public Course findCourseById(int id) {
        return courses.stream().filter(c -> c.getCourseId() == id).findFirst().orElse(null);
    }

    // Get all people
    public List<Person> getAllPeople() {
        List<Person> people = new ArrayList<>();
        people.addAll(students);
        people.addAll(teachers);
        people.addAll(staffMembers);
        return people;
    }

    // Save all data
    public void saveAllRegistrations() {
        storage.saveData(students, "students.txt");
        storage.saveData(teachers, "teachers.txt");
        storage.saveData(staffMembers, "staff.txt");
        storage.saveData(courses, "courses.txt");
    }
}
