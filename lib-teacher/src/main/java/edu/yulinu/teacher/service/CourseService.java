package edu.yulinu.teacher.service;

import edu.yulinu.common.domain.CourseResource;
import edu.yulinu.teacher.dao.CourseDao;
import edu.yulinu.teacher.dao.TeaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: libmanage
 * @description:
 * @author: Xiaodong
 * @date: 2020-04-12 21:58
 **/
@Service
public class CourseService {
    @Autowired
    private CourseDao courseDao;
    public String createCourse(CourseResource courseResource){
        CourseResource save = courseDao.save(courseResource);
        return save!=null?"true":"false";
    }
}
