package edu.knoldus;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import edu.knoldus.entities.ClassRoom;
import edu.knoldus.entities.Student;

/**
 * Created by pallavi on 4/3/18.
 */
public class Operations {
  public static Optional<List<Student>> getStudentsWitNoSubjects(ClassRoom classRoom) {

    return classRoom.students.map(
        list -> list.stream().filter(student -> !student.subjects.isPresent())
            .collect(Collectors.toList()));

  }

  public static void findSubjects(int roomId, List<ClassRoom> rooms) {

    rooms.stream().filter(room -> room.roomId == roomId).map(room -> room.students.get())
        .flatMap(s -> s.stream().map(x -> x.name + x.subjects.get())).forEach(System.out::println);

  }

  public static void printHelloStudent(ClassRoom classRoom) {
    if (classRoom.students.isPresent()) {
      List<Student> list = classRoom.students.get();
      list.forEach(student -> System.out.println("Hello " + student));
    }
  }
}
