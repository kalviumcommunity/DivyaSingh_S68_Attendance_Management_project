package com.school;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Simple file storage service that saves Storable objects to text files.
 */
public class FileStorageService {

    /**
     * Save a list of items that implement Storable into a text file.
     * Each item's toDataString() is written as a single line.
     *
     * @param items    list of storable items
     * @param filename name of the file to write (relative to current working directory)
     */
    public void saveData(List<? extends Storable> items, String filename) {
        int linesWritten = 0;
        try (PrintWriter pw = new PrintWriter(new FileWriter(filename))) {
            for (Storable s : items) {
                String line = s.toDataString();
                pw.println(line);
                linesWritten++;
            }
            System.out.println("Saved " + linesWritten + " records to '" + filename + "'.");
        } catch (IOException e) {
            System.err.println("Error saving data to file '" + filename + "': " + e.getMessage());
            e.printStackTrace();
        }
    }
}
