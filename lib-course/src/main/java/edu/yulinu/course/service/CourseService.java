package edu.yulinu.course.service;

import edu.yulinu.common.domain.CourseResource;
import edu.yulinu.course.dao.CourseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

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
        return save!=null?"成功创建课程 success":"创建失败";
    }

    /***
     * 查询所有课程
      * @return
     */
    public Page<CourseResource> findAll(Integer page,Integer size) {
        return courseDao.findByStatus("open", PageRequest.of(page,size));
    }

    Page<CourseResource> findByTeaId(Integer teaId){
        return courseDao.findByTeaId(teaId);
    }

    /***
     * @param status
     * @param id
     * @return
     */
    @Transactional
    public Object setStatus(String status,Integer id) {
        return courseDao.setStatus(status,id);
    }


//        修改课程学生可选状态
    @Transactional
    public String changeStatus(Integer courseId){
        Optional<CourseResource> byId = courseDao.findById(courseId);
        if(byId.isPresent()){
            CourseResource courseResource = byId.get();
            courseResource.setStatus("open");
            courseDao.save(courseResource);
            return "状态修盖成功";
        }
        return "课程不存在";
    }



}
