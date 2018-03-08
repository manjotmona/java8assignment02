package edu.knoldus;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import edu.knoldus.entities.ClassRoom;
import edu.knoldus.entities.Student;

import static edu.knoldus.Operations.printHelloStudent;

/**
 * Created by pallavi on 4/3/18.
 */
public class Application {

    public static void main(String[] args) {

        List<String> subjects = Arrays.asList("Math", "English", "Science");
        Optional<List<String>> subs = Optional.of(subjects);

        Student mona = new Student("Mona", 1, subs);
        Student jassy = new Student("Jassy", 2, Optional.of(Arrays.asList("Math")));
        Student bawa = new Student("Bawa", 3, Optional.empty());

        List<Student> students = Arrays.asList(mona, jassy, bawa);
        List<Student> students1 = Arrays.asList(mona, jassy);

        ClassRoom classRoom1 = new ClassRoom(1, Optional.of(students));
        ClassRoom classRoom2 = new ClassRoom(2, Optional.of(students1));

        // Operations operations = new Operations();

        System.out.println(Operations.getStudentsWitNoSubjects(classRoom1));

        List<Student> list = printHelloStudent(classRoom1);
        list.forEach(student -> System.out.println("Hello " + student));

        List<ClassRoom> rooms = Arrays.asList(classRoom1, classRoom2);

        System.out.println(Operations.findSubjects(2, rooms));
        // Operations.findSubjects(2, rooms);

        System.out.println(Arrays.asList(bawa));

    }

}
