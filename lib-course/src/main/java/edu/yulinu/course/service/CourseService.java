package edu.yulinu.course.service;

import edu.yulinu.common.domain.CourseResource;
import edu.yulinu.course.dao.CourseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    /***
     * 查询所有课程
      * @return
     */
    public Page<CourseResource> findAll(Integer page,Integer size) {
        return courseDao.findByStatus("open", PageRequest.of(page,size));
    }


    @Transactional
    public Object setStatus(String status,Integer id) {
        return courseDao.setStatus(status,id);
    }
}
