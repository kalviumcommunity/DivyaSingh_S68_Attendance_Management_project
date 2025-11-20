package com.school;

/**
 * Base class Person with auto-increment ID and common fields.
 */
public class Person {
    private static int nextIdCounter = 1;   // universal counter for all Person-derived objects

    protected final int id;     // accessible to subclasses
    protected String name;

    public Person(String name) {
        this.id = nextIdCounter++;
        setName(name);
    }

    public int getId() { return id; }
    public String getName() { return name; }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) throw new IllegalArgumentException("Name cannot be empty");
        this.name = name.trim();
    }

    // Display id and name
    public void displayDetails() {
        System.out.printf("Person -> ID: %d, Name: %s%n", id, name);
    }
}
