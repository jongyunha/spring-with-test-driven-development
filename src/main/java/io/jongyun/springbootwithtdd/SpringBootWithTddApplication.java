package io.jongyun.springbootwithtdd;

import io.jongyun.springbootwithtdd.models.CollegeStudent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

@SpringBootApplication
public class SpringBootWithTddApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringBootWithTddApplication.class, args);
  }

  @Bean(name = "collegeStudent")
  @Scope(value = "prototype")
  CollegeStudent getCollegeStudent() {
    return new CollegeStudent();
  }
}
