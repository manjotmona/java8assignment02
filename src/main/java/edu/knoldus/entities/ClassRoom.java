package edu.knoldus.entities;

import java.util.List;
import java.util.Optional;

/**
 * Created by pallavi on 4/3/18.
 */
public class ClassRoom {

    public int roomId;
    public Optional<List<Student>> students;

    public ClassRoom(int roomId, Optional<List<Student>> students) {
        this.roomId = roomId;
        this.students = students;
    }

    public String toString() {
        return Integer.toString(roomId);
    }
}
