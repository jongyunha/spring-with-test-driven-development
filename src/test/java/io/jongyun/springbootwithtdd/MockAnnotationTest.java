package io.jongyun.springbootwithtdd;

import io.jongyun.springbootwithtdd.dao.v2.ApplicationDaoV2;
import io.jongyun.springbootwithtdd.models.CollegeStudent;
import io.jongyun.springbootwithtdd.models.StudentGrades;
import io.jongyun.springbootwithtdd.service.ApplicationServiceV2;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

/**
 * @author jongyunha created on 22. 7. 17.
 */
@SpringBootTest(classes = SpringBootWithTddApplication.class)
public class MockAnnotationTest {

    @Autowired
    ApplicationContext context;

    @Autowired
    CollegeStudent studentOne;

    @Autowired
    StudentGrades studentGrades;

    @Mock
    private ApplicationDaoV2 applicationDaoV2;

    @InjectMocks
    private ApplicationServiceV2 applicationServiceV2;

    @BeforeEach
    void before() {
        studentOne.setLastname("Jongyun");
        studentOne.setFirstname("Ha");
        studentOne.setEmailAddress("popawaw@naver.com");
        studentOne.setStudentGrades(studentGrades);
    }

}
