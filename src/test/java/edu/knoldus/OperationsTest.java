package edu.knoldus;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import edu.knoldus.entities.ClassRoom;
import edu.knoldus.entities.Student;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by pallavi on 5/3/18.
 */
public class OperationsTest {

    private static Operations operation;
    List<String> subjects = Arrays.asList("Math", "English", "Science");
    Optional<List<String>> subs = Optional.of(subjects);
    Student mona = new Student("Mona", 1, subs);
    Student jassy = new Student("Jassy", 2, Optional.of(Arrays.asList("Math")));
    Student bawa = new Student("Bawa", 3, Optional.empty());

    List<Student> students = Arrays.asList(mona, jassy, bawa);
    List<Student> students1 = Arrays.asList(mona, jassy);

    ClassRoom classRoom_1 = new ClassRoom(1, Optional.of(students));
    ClassRoom classRoom_2 = new ClassRoom(2, Optional.of(students1));
    ClassRoom classRoom_empty = new ClassRoom(2, Optional.empty());
    List<ClassRoom> rooms = Arrays.asList(classRoom_1, classRoom_2);

    @BeforeClass public static void setUp() {
        operation = new Operations();

    }

    @Test public void getStudentsWitNoSubjects() {
        List<Student> studentList = Operations.getStudentsWitNoSubjects(classRoom_1);
        List<Student> expectedResult = Arrays.asList(bawa);
        assertEquals("method_1 Testing", expectedResult, studentList);

    }

    @Test public void findSubjects() {
        List<String> subjectsList = Operations.findSubjects(2, rooms);
        List<String> expectedResult =
                Arrays.asList(mona.name + mona.subjects.get(), jassy.name + jassy.subjects.get());
        assertEquals("method_2 Testing", expectedResult, subjectsList);
    }

    @Test public void printHelloStudent() {
        List<Student> studentList = Operations.printHelloStudent(classRoom_1);
        List<Student> expectedResult = Arrays.asList(mona, jassy, bawa);
        assertEquals("method_2 Testing", expectedResult, studentList);
        List<Student> emptyStudentList = Operations.printHelloStudent(classRoom_empty);
        assertEquals("method_2 for empty list",Arrays.asList(),emptyStudentList);

    }



}