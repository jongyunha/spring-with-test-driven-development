package io.jongyun.springbootwithtdd;

import io.jongyun.springbootwithtdd.models.CollegeStudent;
import io.jongyun.springbootwithtdd.models.StudentGrades;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

// package 명과 test 폴더 명이 다를 경우 명시적으로 classes 를 적어준다.
@SpringBootTest(classes = SpringBootWithTddApplication.class)
class SpringBootWithTddApplicationTests {

  private static int count = 0;

  @Value("${info.app.name}")
  private String appInfo;

  @Value("${info.app.description}")
  private String appDescription;

  @Value("${info.app.version}")
  private String appVersion;

  @Value("${info.school.name}")
  private String schoolName;

  @Autowired CollegeStudent student;

  @Autowired StudentGrades studentGrades;

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

  @Test
  void basicTest() {}
}
