package com.school;

/**
 * Marker interface for objects that can be saved to text storage.
 */
public interface Storable {
    /**
     * Return a CSV-style line representing this object suitable for storage.
     * Example: "1,Alice Johnson,Grade 12"
     */
    String toDataString();
}
