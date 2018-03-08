package edu.knoldus.entities;

import java.util.List;
import java.util.Optional;

/**
 * Created by pallavi on 4/3/18.
 */
public class Student {

    public String name;
    public int rollNumber;
    public Optional<List<String>> subjects;

    public Student(String name, int rollNumber, Optional<List<String>> subject) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.subjects = subject;
    }

    public String toString() {
        return this.name;
    }

}
