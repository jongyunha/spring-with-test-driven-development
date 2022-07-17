package io.jongyun.springbootwithtdd.service;

import io.jongyun.springbootwithtdd.dao.v2.ApplicationDaoV2;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

public class ApplicationServiceV2 {

    @Autowired
    private ApplicationDaoV2 applicationDao;

    public double addGradeResultsForSingleClass(List<Double> numbers) {
        return applicationDao.addGradeResultsForSingleClass(numbers);
    }

    public double findGradePointAverage(List<Double> grades) {
        return applicationDao.findGradePointAverage(grades);
    }

    public Object checkNull(Object obj) {
        return applicationDao.checkNull(obj);
    }

}