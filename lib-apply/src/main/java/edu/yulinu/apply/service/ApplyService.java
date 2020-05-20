package edu.yulinu.apply.service;

import edu.yulinu.apply.dao.ApplyDao;
import edu.yulinu.common.domain.ApplyRecord;
import edu.yulinu.common.domain.CourseResource;
import edu.yulinu.common.domain.Student;
import edu.yulinu.course.dao.CourseDao;
import edu.yulinu.student.dao.StuDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Optional;

/**
 * @program: libmanage
 * @description:
 * @author: Xiaodong
 * @date: 2020-04-21 19:08
 **/
@Service
public class ApplyService {

    @Autowired
    private ApplyDao applyDao;
    @Autowired
    private CourseDao courseDao;
    @Autowired
    private StuDao stuDao;

//    申请资源
    @Transactional
    public String applyCourse(Integer courseId, Integer userId){

//      获取资源数据
        ApplyRecord record = combinedApplyData(courseId, userId);
//      插入申请记录
        return applyDao.save(record)!=null?"申请成功":"课程学习人数已满";
    }


//    整理申请数据
    private ApplyRecord combinedApplyData(Integer courseId, Integer userId){

        Student student=null;
        CourseResource course=null;
        Optional<Student> byId = stuDao.findById(userId);
        if(byId.isPresent()){
            student = byId.get();
        }
        Optional<CourseResource> courseROptional = courseDao.findById(courseId);
        if(courseROptional.isPresent()){
            course = courseROptional.get();
        }
        if(course.getLearnerAmount()>=course.getStudentLimit()){
            return null;
        }else{
            course.setLearnerAmount(course.getLearnerAmount()+1);
        }
        courseDao.save(course);
        return ApplyRecord.builder()
                .applyTime(LocalDate.now())
                .courseName(course.getCourseName())
                .isApprove("no")
                .record(0)
                .courseId(courseId)
                .stuName(student.getStuName())
                .stuId(student.getStuNo())
                .stuNo(student.getStuNo())
                .teaId(course.getTeaId())
                .teaName(course.getTeaName())
                .build();
    }
}
