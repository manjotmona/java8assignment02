package edu.knoldus;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import edu.knoldus.entities.ClassRoom;
import edu.knoldus.entities.Student;

/**
 * Created by pallavi on 4/3/18.
 */
public class Operations {
    public static List<Student> getStudentsWitNoSubjects(ClassRoom classRoom) {

        Optional<List<Student>> s = classRoom.students
                .map(list -> list.stream().filter(student -> !student.subjects.isPresent())
                        .collect(Collectors.toList()));
        return s.get();

    }

    public static List<String> findSubjects(int roomId, List<ClassRoom> rooms) {

        Stream<String> stringStream = rooms.stream().filter(room -> room.roomId == roomId)
                .map(room -> room.students.get())
                .flatMap(s -> s.stream().map(x -> x.name + x.subjects.get()));

        List<String> result = stringStream.collect(Collectors.toList());
        return result;

    }

    public static List<Student> printHelloStudent(ClassRoom classRoom) {
        if (classRoom.students.isPresent()) {
            List<Student> list = classRoom.students.get();
            //list.forEach(student -> System.out.println("Hello " + student));
            return list;
        } else {
            return Collections.emptyList();
        }
    }
}
