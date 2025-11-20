package com.school;

/**
 * Staff extends Person (non-teaching staff).
 */
public class Staff extends Person {
    private String role;

    public Staff(String name, String role) {
        super(name);
        setRole(role);
    }

    public String getRole() { return role; }
    public void setRole(String role) {
        if (role == null || role.trim().isEmpty()) role = "Staff";
        this.role = role.trim();
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.printf("  Role: Non-Teaching Staff, Position: %s%n", role);
    }

    @Override
    public String toString() {
        return String.format("Staff{X%d, name='%s', role='%s'}", id, name, role);
    }
}
