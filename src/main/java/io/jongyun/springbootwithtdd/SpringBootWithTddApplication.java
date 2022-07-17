package io.jongyun.springbootwithtdd;

import io.jongyun.springbootwithtdd.dao.v2.ApplicationDaoV2;
import io.jongyun.springbootwithtdd.models.CollegeStudent;
import io.jongyun.springbootwithtdd.service.ApplicationServiceV2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

@SpringBootApplication
public class SpringBootWithTddApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootWithTddApplication.class, args);
    }

    /* New for Section 2.2 */
    @Bean(name = "applicationExample")
    ApplicationServiceV2 getApplicationService() {
        return new ApplicationServiceV2();
    }

    /* New for Section 2.2 */
    @Bean(name = "applicationDao")
    ApplicationDaoV2 getApplicationDao() {
        return new ApplicationDaoV2();
    }

    @Bean(name = "collegeStudent")
    @Scope(value = "prototype")
    CollegeStudent getCollegeStudent() {
        return new CollegeStudent();
    }

}
