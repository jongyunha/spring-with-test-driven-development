package io.jongyun.springbootwithtdd;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import io.jongyun.springbootwithtdd.models.CollegeStudent;
import io.jongyun.springbootwithtdd.models.StudentGrades;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

// package 명과 test 폴더 명이 다를 경우 명시적으로 classes 를 적어준다.
@SpringBootTest(classes = SpringBootWithTddApplication.class)
class SpringBootWithTddApplicationTests {

  private static int count = 0;
  @Autowired CollegeStudent student;
  @Autowired StudentGrades studentGrades;

  @Value("${info.app.name}")
  private String appInfo;

  @Value("${info.app.description}")
  private String appDescription;

  @Value("${info.app.version}")
  private String appVersion;

  @Value("${info.school.name}")
  private String schoolName;

  @BeforeEach
  public void beforeEach() {
    count += 1;
    System.out.println(
        "Testing: "
            + appInfo
            + " which is "
            + appDescription
            + " Version: "
            + appVersion
            + ". Execution of test method "
            + count);
    student.setFirstname("Eric");
    student.setLastname("Roby");
    student.setEmailAddress("popawaw@naver.com");
    studentGrades.setMathGradeResults(new ArrayList<>(Arrays.asList(100.0, 85.0, 76.50, 91.75)));
    student.setStudentGrades(studentGrades);
  }

  @DisplayName("Add grade results for student grades")
  @Test
  public void addGradeResultsForStudentGrades() {
    assertEquals(
        353.25,
        studentGrades.addGradeResultsForSingleClass(
            student.getStudentGrades().getMathGradeResults()));
  }

  @DisplayName("Add grade results for student grades not equal")
  @Test
  public void addGradeResultsForStudentGradesAssertNotEquals() {
    assertNotEquals(
        0,
        studentGrades.addGradeResultsForSingleClass(
            student.getStudentGrades().getMathGradeResults()));
  }

  @DisplayName("Is grade greater")
  @Test
  public void isGradeGreaterStudentGrades() {
    assertTrue(studentGrades.isGradeGreater(90, 75), "failure - should be ture");
  }

  @DisplayName("Is grade greater false")
  @Test
  public void isGradeGreaterStudentGradesAssertFalse() {
    assertFalse(studentGrades.isGradeGreater(89, 92), "failure - should be false");
  }

  @DisplayName("Check Null for student grades")
  @Test
  public void checkNullForStudentGrades() {
    assertNotNull(
        studentGrades.checkNull(student.getStudentGrades().getMathGradeResults()),
        "object should not be null");
  }
}
