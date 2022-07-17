package io.jongyun.springbootwithtdd;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import io.jongyun.springbootwithtdd.dao.v2.ApplicationDaoV2;
import io.jongyun.springbootwithtdd.models.CollegeStudent;
import io.jongyun.springbootwithtdd.models.StudentGrades;
import io.jongyun.springbootwithtdd.service.ApplicationServiceV2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
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

    //    @Mock -> @MockBean 주어진 bean 을 주입합니다.
    @MockBean
    private ApplicationDaoV2 applicationDaoV2;

    //    @InjectMocks -> @Autowired
    // MockBean 을 사용함으로 인해서 Application context 에서 bean 이 등록되어 있으므로 의존성 주입이 가능해짐
    @Autowired
    private ApplicationServiceV2 applicationServiceV2;

    @BeforeEach
    void before() {
        studentOne.setLastname("Jongyun");
        studentOne.setFirstname("Ha");
        studentOne.setEmailAddress("popawaw@naver.com");
        studentOne.setStudentGrades(studentGrades);
    }

    @DisplayName("When & Verify")
    @Test
    void assertEqualsTestAddGrades() {
        when(applicationDaoV2.addGradeResultsForSingleClass(studentGrades.getMathGradeResults()))
            .thenReturn(100.0);

        assertEquals(100, applicationServiceV2
            .addGradeResultsForSingleClass(studentOne.getStudentGrades().getMathGradeResults()));

        // 이 method 가 호출되었는지 검증
        verify(applicationDaoV2).addGradeResultsForSingleClass(studentGrades.getMathGradeResults());

        // 이 method 가 몇번 호출되었는지 검증
        verify(applicationDaoV2, times(1)).addGradeResultsForSingleClass(
            studentGrades.getMathGradeResults());
    }

    @DisplayName("Find Gpa")
    @Test
    void assertEqualsTestFindGpa() {
        when(applicationDaoV2.findGradePointAverage(studentGrades.getMathGradeResults()))
            .thenReturn(88.31);

        assertEquals(88.31, applicationServiceV2
            .findGradePointAverage(studentOne.getStudentGrades().getMathGradeResults()));

        verify(applicationDaoV2).findGradePointAverage(studentGrades.getMathGradeResults());
        verify(applicationDaoV2, times(1)).findGradePointAverage(
            studentGrades.getMathGradeResults());
    }

}
