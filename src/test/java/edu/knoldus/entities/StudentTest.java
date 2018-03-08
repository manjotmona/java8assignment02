package edu.knoldus.entities;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by pallavi on 5/3/18.
 */
public class StudentTest {
    private static Student student;
    List<String> subjects = Arrays.asList("Math", "English", "Science");
    Optional<List<String>> subs = Optional.of(subjects);

    Student mona = new Student("mona", 1, subs);

    @BeforeClass public static void setUp() {

    }
  @Test
  public final void  getToString() {

      String actualResult = mona.toString();
      assertEquals("mona",actualResult);
     // return "1";


  }

}